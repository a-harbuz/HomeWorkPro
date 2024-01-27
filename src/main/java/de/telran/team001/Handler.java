package de.telran.team001;
import de.telran.myexeptions.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import de.telran.myexeptions.ErrorMessages.*;

public class Handler {

    private static Map<Team<Participant>, Double> resultGamesMap = new LinkedHashMap<>(); // All Results

    public static void play(List<List<Team<Participant>>> teamsList){
        //Commands play in each Group
        //Если победа то присуждается 1 балл, если ничья 0,5, если проигрыш то 0.
        for (int i = 0; i < teamsList.size(); i++) {
            List<Team<Participant>> lt = teamsList.get(i); // => list teams
            playInGroup(lt);

        }
        //У первой тройки лидеров результаты должны отличаться. Если первые 5 мест одинаковое кол-во баллов,
        //то играют с одинаковыми баллами между собой, пока не определиться тройка лидеров.

        //Sort Map by Value
        Map<Team<Participant>, Double> checkMap = new LinkedHashMap<>();
        resultGamesMap = resultGamesMap.entrySet().stream()
                        .sorted(Map.Entry.<Team<Participant>, Double>comparingByValue().reversed())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));
        checkMap = resultGamesMap.entrySet().stream()
                .sorted(Map.Entry.<Team<Participant>, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        //System.out.println(sortedMap);
        // Проверка, что все значения одинаковы
        if (checkMap.values().stream().distinct().count() == 1) {
            //System.out.println("Все 5 значений одинаковы");
            Handler.play(teamsList);
            return;
        }

        // Проверка, что в первых трех элементах есть повторяющиеся значения
        boolean isDuplicatesInFirstThree = checkMap.entrySet().stream()
                .limit(3)
                .map(Map.Entry::getValue)
                .distinct()
                .count() < 3;
        // isDuplicatesInFirstThree = true, если есть повторяющиеся значения, иначе она будет равна false.
        if (isDuplicatesInFirstThree) {
            //System.out.println("3 значения не уникальны");
            Handler.play(teamsList);
            return;
        }
//        while (isDuplicatesInFirstThree){
//            Handler.play(teamsList);
//        }

    }
    public static void playInGroup(List<Team<Participant>> teamsList){
        if (teamsList.isEmpty()){
            //throw new TeamNotBeEmpty("Team not be null");
            throw new TeamNotBeEmpty(ErrorMessages.PARAM_MUST_BE_NOT_NULL);
            //throw new ParameterAIsMustBeNotFiveException(ErrorMessages.PARAM_MUST_BE_NOT_NULL);
        }
        //plays in one Group
        for (int i = 0; i < teamsList.size(); i++) {
            double result = 0;
            for (int j = i; j < teamsList.size(); j++) {
                if (i!=j) {
                    double ball = teamsList.get(i).play(teamsList.get(j));
                    result += ball;
                    //!!!
                    if (ball==1.0) teamsList.get(i).addiamWin(teamsList.get(j)); //Добавление команд у которых выиграли
                }
            }
            //!!!
            teamsList.get(i).setPunkte(result); //Добавление баллов в класс
            resultGamesMap.put(teamsList.get(i),result);
        }
    }

    public static void showResultGameMap(){
        resultGamesMap.entrySet().stream()
                .forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getValue()));
    }

    public static void showTeams(List<List<Team<Participant>>> teamsList){
        teamsList.stream()
                .flatMap(Collection::stream)
                .forEach(x->System.out.println(x.getTeamName() + " : " + x.getPunkte()));
    }

//=========================================Statistic===============================================
    //Найти команду с максимальными баллами: ++
    public static void teamMax(List<List<Team<Participant>>> teamsList){
        Optional<Map.Entry<Team<Participant>, Double>> maxEntry = resultGamesMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.print("Команда с максимальными баллами: ");
        System.out.println(maxEntry.get().getKey().getTeamName() + " : " + maxEntry.get().getValue());

    }

    //Подсчет общего количества баллов: ++
    public static void sumValue(){
        Double s = resultGamesMap.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println("Всего баллов: " + s);
    }

    //Список команд без баллов: ++
    public static void noPoints(){
        System.out.println("Список команд без баллов: ");
        resultGamesMap.entrySet().stream()
                .filter(x->x.getValue().equals(0.0))
                .forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getValue()));
    }
    //Средний возраст участников в каждой команде: ++
    public static void middleAge(){
        System.out.println("Средний возраст участников в каждой команде: ");
        for (Map.Entry<Team<Participant>,Double> m : resultGamesMap.entrySet()) {
            Double avg = m.getKey().getParticipantList().stream()
                    .collect(Collectors.averagingInt(Participant::getAge)); //Получили средний балл участников в команде
            System.out.println(m.getKey().getTeamName()+" : "+avg);
        }

    }

    //Команды с баллами выше среднего: ++
    public static void moreThanMiddle(){
        double resSum = resultGamesMap.entrySet().stream()
                .collect(Collectors.averagingDouble(x-> x.getValue()));
        System.out.println("Средний балл: "+resSum);

        resultGamesMap.entrySet().stream()
                .filter(x -> x.getValue() > resSum)
                .forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getValue()));
    }

    //Сортировка команд по баллам: ++
    public static void teamSortedByPunkte(){
        //Sort Map by Value
        resultGamesMap.entrySet().stream()
                .sorted(Map.Entry.<Team<Participant>, Double>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    //Команды с определенной категорией участников: Вывести команды, где все участники
    //принадлежат к одной категории (например, только Adult). ++
    public static void onlyOneCategory(){
        //фильтр, и перебор
        resultGamesMap.entrySet().stream()
                .filter(x->x.getKey().getGroup().equals(GroupTeams.ADULT))
                .forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getKey().getGroup()));
    }

    //Команды с победами над определенной командой: Определить команды, которые выиграли
    //у заданной команды. ++
    public static void whoWin() {
        //Team.List<UkogoViigrali>.stream
        //streamList - >фильтр(UkogoViigrali==secondTeam)
        resultGamesMap.keySet().stream()
                .map(x -> x.getIamWinList().stream())
                .forEach(System.out::println);
    }

    //Самый молодой участник среди всех команд: ++
    public static void soYung(){
//        double age= Double.MAX_VALUE;
//        for (Map.Entry<Team<Participant>,Double> m : resultGamesMap.entrySet()){
//            List<Participant> lst1 = m.getKey().getParticipantList();
//            for (int i = 0; i < lst1.size(); i++) {
//                if (lst1.get(i).getAge()<age) age=lst1.get(i).getAge();
//            }
//        }
//        System.out.println("Minimal Age: " + age);

          double age = resultGamesMap.keySet().stream() //stream Teams
                .flatMap(t -> t.getParticipantList().stream()) //stream Participant
                .mapToDouble(Participant::getAge)
                .min()
                .orElse(Double.MIN_VALUE);

        System.out.println("Minimal Age: " + age);
    }

    //Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников. ++
    public static void soExpiriens() {
//        Map<Team<Participant>,Integer> sumAge = new HashMap<>();
//        for (Map.Entry<Team<Participant>, Double> m : resultGamesMap.entrySet()) {
//            List<Participant> lst1 = m.getKey().getParticipantList();
//            int age = 0;
//            for (Participant participant: lst1) {
//                age+=participant.getAge();
//            }
//            sumAge.put(m.getKey(), age);
//        }
//
//        int maxAge = Integer.MIN_VALUE;
//        Team<Participant> maxTeam = new Team<>();
//        for (Map.Entry<Team<Participant>,Integer> m : sumAge.entrySet()) {
//            if (m.getValue()>maxAge) {
//                maxAge=m.getValue();
//                maxTeam=m.getKey();
//            }
//        }
//        System.out.println("Max Age: " + maxAge);
//        System.out.println("MaxAge Team: " + maxTeam.getTeamName());

        //составить список Команда=ср.возраст
        //найти максимум

        Map<Team<Participant>, Integer> mapSumAge = new LinkedHashMap<>();
        for (Map.Entry<Team<Participant>,Double> m : resultGamesMap.entrySet()) {
            Integer sum = m.getKey().getParticipantList().stream()
                    .mapToInt(Participant::getAge)
                    .sum();
            //System.out.println(sum);
            mapSumAge.put(m.getKey(), sum);
        }
            Double age = mapSumAge.values().stream()
                .mapToDouble(el->el)
                .max()
                .orElse(Double.MIN_VALUE);
            System.out.println(age);
    }


    //Команды с участниками в определенном возрастном диапазоне: ++
    public static void teamFromTo(int a, int b) {
        if (a<=0 || b>100) {
            throw new NoValidRangeAge(ErrorMessages.AGE_MUST_BE_IN_RANGE);
        }

        System.out.println("Команды с участниками в определенном возрастном диапазоне ("+a+"-"+b+") age:");
        //Optional<String> teamName =
        resultGamesMap.keySet().stream()
                .filter(team -> team.getParticipantList().stream()
                        .anyMatch(participant -> (participant.getAge() >= a) && (participant.getAge() <= b)
                        ))
                //.map(Team::getTeamName)
                .forEach(x->System.out.println(x.getTeamName()));

    }


    //Имена участников по убыванию возраста: ++
    public static void participantsByAge() {
        System.out.println("Имена участников по убыванию возраста:");
        resultGamesMap.keySet().stream()
                .flatMap(x->x.getParticipantList().stream())
                .sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
                .forEach(x-> System.out.println(x.getName() + " : " + x.getAge()));
    }

    //Найти команду с наибольшим разбросом возрастов участников.
    public static void participantsByMaxDifferentAge() {
        //???????
    }

    //Найти все пары команд, чьи участники имеют одинаковый суммарный возраст. ++
    public static void participantsByGleichAge() {
        //Цикл в цикле стримами
        resultGamesMap.keySet().stream().forEach(team1 ->
                resultGamesMap.keySet().stream().forEach(team2 -> {
                    if (team1 != team2) {
                        int totalAgeTeam1 = team1.getParticipantList().stream().mapToInt(Participant::getAge).sum();
                        int totalAgeTeam2 = team2.getParticipantList().stream().mapToInt(Participant::getAge).sum();

                        if (totalAgeTeam1 == totalAgeTeam2) {
                            System.out.println(team1.getTeamName() + "-" + totalAgeTeam1 +
                                    " : " + team2.getTeamName() + "-" + totalAgeTeam2);
                        }
                    }
                }
                ));
    }

    //Вычислить средний балл для команд в каждой категории участников (Adult, Teenager, Pupil).

    //Найти команды, чьи баллы улучшались с каждой игрой.

    //Выявить команды, которые не имеют проигрышей.
    //Список команд, которые имели ничейные результаты с заданной командой.
    //Вывести результаты всех игр между двумя конкретными командами.
    //Сравнить две команды по средним баллам и среднему возрасту участников.

    //Найти команды, в которых все участники имеют уникальные имена.
    //Определить команды с самой длинной последовательностью побед.
    //Найти команды с наибольшим количеством ничьих результатов.
    //Выявить команды, которые показали наибольшее улучшение баллов к концу сезона.

    //Создать комплексный отчет, включающий средний возраст команды, общее количество баллов,
    //наибольшую победную серию, и сравнение с другими командами.


} // End of Class

