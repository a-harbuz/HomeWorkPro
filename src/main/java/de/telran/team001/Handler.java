package de.telran.team001;
import de.telran.myexeptions.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        resultGamesMap = resultGamesMap.entrySet().stream()
                        .sorted(Map.Entry.<Team<Participant>, Double>comparingByValue().reversed())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));
        //System.out.println(sortedMap);

        // Проверка, что все значения одинаковы
        if (resultGamesMap.values().stream().limit(5).distinct().count() == 1) {
            //System.out.println("Все 5 значений одинаковы");
            Handler.play(teamsList);
            return;
        }

        // Проверка, что в первых четырех элементах есть повторяющиеся значения
        // т.е. 3 первых места - должны остаться уникалными
        boolean isDuplicatesInFirstFour = resultGamesMap.entrySet().stream()
                .limit(4)
                .map(Map.Entry::getValue)
                .distinct()
                .count() < 4;
        // isDuplicatesInFirst = true, если есть повторяющиеся значения, иначе она будет равна false.
        if (isDuplicatesInFirstFour) {
            //System.out.println("4 значения не уникальны");
            Handler.play(teamsList); //recursion
            //return;
        }

    }

    public static void playInGroup(List<Team<Participant>> teamsList){
        if (teamsList.isEmpty()){
            //throw new TeamNotBeEmpty("Team not be null");
            throw new TeamNotBeEmpty(ErrorMessages.PARAM_MUST_BE_NOT_NULL);
        }
        //plays in one Group
        for (int i = 0; i < teamsList.size(); i++) {
            double result = 0;
            int winnersCount = 0;
            for (int j = i; j < teamsList.size(); j++) {
                if (i!=j) {
                    double ball = teamsList.get(i).play(teamsList.get(j));
                    result += ball;
                    //!!!
                    //Добавление в МАПУ команд с которыми играли, с результатом игры
                    teamsList.get(i).addiamWinMap(teamsList.get(j), ball);
                    if (ball==1.0) {
                        winnersCount++;
                    } else {
                        if (winnersCount > teamsList.get(i).getWinnersCount()) {
                            //Записываем новую победную серию, если она больше старой
                            teamsList.get(i).setWinnersCount(winnersCount);
                        }
                        winnersCount=0;
                    }
                }
            }
            //!!!
            teamsList.get(i).setPunkte(result); //Добавление баллов в класс
            resultGamesMap.put(teamsList.get(i),result);
        }
    }

    public static void showResultGameMap(){
        resultGamesMap.forEach((key, value) -> System.out.println(key.getTeamName() + " : " + value));
    }

    public static void showTeams(List<List<Team<Participant>>> teamsList){
        teamsList.stream()
                .flatMap(Collection::stream)
                .forEach(x->System.out.println(x.getTeamName() + " : " + x.getPunkte()));
    }

//=========================================Statistic===============================================
    //Найти команду с максимальными баллами: ++
//    public static void teamMax(List<List<Team<Participant>>> teamsList){
//        Map.Entry<Team<Participant>, Double> maxEntry = resultGamesMap.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .orElse(null);
//
//        System.out.print("Команда с максимальными баллами: ");
//        System.out.println(maxEntry.getKey().getTeamName() + " : " + maxEntry.getValue());
//
//    }
    public static Map.Entry<Team<Participant>, Double> teamMax(Map<Team<Participant>, Double> inputMap){
        return inputMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }

    //Подсчет общего количества баллов: ++
    public static Double sumValue(){
        return resultGamesMap.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        //System.out.println("Всего баллов: " + s);
    }

    //Список команд без баллов: ++
    public static Map<Team<Participant>, Double> noPoints(){
//        System.out.println("Список команд без баллов: ");
//        resultGamesMap.entrySet().stream()
//                .filter(x->x.getValue().equals(0.0))
//                .forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getValue()));
        return resultGamesMap.entrySet().stream()
                .filter(x->x.getValue().equals(0.0))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    //Средний возраст участников в каждой команде: ++
    public static Map<Team<Participant>, Double> middleAge(){
//        System.out.println("Средний возраст участников в каждой команде: ");
//        for (Map.Entry<Team<Participant>,Double> m : resultGamesMap.entrySet()) {
//            double avg;
//            avg = m.getKey().getParticipantList().stream()
//                    .collect(Collectors.averagingInt(Participant::getAge)); //Получили средний балл участников в команде
//            System.out.println(m.getKey().getTeamName()+" : "+avg);
//        }
        return resultGamesMap.keySet().stream()
                .collect(Collectors.toMap(t->t, t->{
                    return t.getParticipantList().stream()
                            .collect(Collectors.averagingDouble(Participant::getAge));
                }));
    }

    //Команды с баллами выше среднего: ++
    public static List<Team<Participant>> moreThanMiddle(){
        double resSum = resultGamesMap.entrySet().stream()
                .collect(Collectors.averagingDouble(Map.Entry::getValue));
        System.out.println("Средний балл: "+resSum);

//        resultGamesMap.entrySet().stream()
//                .filter(x -> x.getValue() > resSum)
//                .forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getValue()));
        return resultGamesMap.entrySet().stream()
                .filter(x -> x.getValue() > resSum)
                .map(Map.Entry::getKey)
                .toList();
    }

    //Сортировка команд по баллам: ++
    public static LinkedHashMap<Team<Participant>, Double> teamSortedByPoint(){
        //Sort Map by Value
//        resultGamesMap.entrySet().stream()
//                .sorted(Map.Entry.<Team<Participant>, Double>comparingByValue().reversed())
//                .forEach(System.out::println);
        return resultGamesMap.entrySet().stream()
                .sorted(Map.Entry.<Team<Participant>, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    //Команды с определенной категорией участников: Вывести команды, где все участники
    //принадлежат к одной категории (например, только Adult). ++
    public static List<Team<Participant>> onlyOneCategory(){
        return resultGamesMap.keySet().stream()
                .filter(x -> x.getGroup().equals(GroupTeams.ADULT))
                .collect(Collectors.toList());
                //.forEach(x->System.out.println(x.getTeamName() + " : " + x.getGroup()));
    }

    //Команды с победами над определенной командой: ++
    //Определить команды, которые выиграли у заданной команды. ++
    public static void whoWin() {
        resultGamesMap.keySet().stream()
                .flatMap(x->x.getIamWinMap().entrySet().stream()) //the MAP inside Team
                .filter(score->score.getValue()==0.0) //текущая команда проиграла этой
                .forEach(y->{
                    System.out.println(y.getKey()); //выводим кто победил у текущей
                });
    }

    //Самый молодой участник среди всех команд: ++
    public static void soYung(){
          double age = resultGamesMap.keySet().stream() //stream Teams
                .flatMap(t -> t.getParticipantList().stream()) //stream Participant
                .mapToDouble(Participant::getAge)
                .min()
                .orElse(Double.MIN_VALUE);

        System.out.println("Minimal Age: " + age);
    }

    //Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников. ++
    public static void soExpiriens() {
        //Ищем суммарный возраст участников в комманде
        Map<Team<Participant>, Integer> mapSumAge = new LinkedHashMap<>();
        for (Map.Entry<Team<Participant>,Double> m : resultGamesMap.entrySet()) {
            Integer sum = m.getKey().getParticipantList().stream()
                    .mapToInt(Participant::getAge)
                    .sum();
            //System.out.println(sum);
            mapSumAge.put(m.getKey(), sum);
        }
        //Определяем больший суммарный возраст
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
        resultGamesMap.keySet().stream()
                .filter(team -> team.getParticipantList().stream()
                        .anyMatch(participant -> (participant.getAge() >= a) && (participant.getAge() <= b)
                        ))
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

    //Найти команду с наибольшим разбросом возрастов участников. ??
    public static void participantsByMaxDifferentAge() {
        //Team-Participant->find min & max => разброс=max-min;
        //складывать в мапу - Team:разброс
        //поиск макс. разброса
    }

    //Найти все пары команд, чьи участники имеют одинаковый суммарный возраст. ++
    public static void participantsByGleichAge() {
        //Цикл в цикле стримами
        resultGamesMap.keySet().forEach(team1 ->
                resultGamesMap.keySet().forEach(team2 -> {
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

    //Вычислить средний балл для команд в каждой категории участников (Adult, Teenager, Pupil). ++
    public static void groupAveragingScore() {
        //key-> groupingBy (Team::getGroup, && value -> averaging)
        Map<GroupTeams, Double> result = resultGamesMap.keySet().stream()
                .collect(Collectors.groupingBy(Team::getGroup, Collectors.averagingDouble(Team::getPunkte)));
        System.out.println(result);
    }

    //Найти команды, чьи баллы улучшались с каждой игрой. ***** ??
    public static void besserEachPlay() {
        //????
    }

    //Выявить команды, которые не имеют проигрышей. ++
    public static void noLossTeam() {
        System.out.println("команды, которые не имеют проигрышей:");
        resultGamesMap.keySet().forEach(
                x->{
                    if (x.getIamWinMap().values().stream().anyMatch(score -> score != 0)){
                        System.out.println(x.getTeamName());
                    }
                }
        );
    }

    //Список команд, которые имели ничейные результаты с заданной командой. ++
    public static void teamsDrawWithTeam(String nameTeam2) {
        System.out.println("Список команд, которые имели ничейные результаты с заданной командой:");
        resultGamesMap.keySet().forEach(
                x->{
                    x.getIamWinMap().forEach((key, value) -> {
                        if (key.getTeamName().equals(nameTeam2) && (value == 0.5)) {
                            System.out.println(x.getTeamName());
                        }
                    });
                }
        );
    }

    //Вывести результаты всех игр между двумя конкретными командами. ++
    public static void resultTeamWithTeam(String nameTeam1, String nameTeam2) {
        System.out.println("Результаты всех игр между двумя конкретными командами:");
        //стрим в стриме (мапа в мапе)
        resultGamesMap.keySet().stream()
                .filter(t1->t1.getTeamName().equals(nameTeam1))
                .forEach(x->{
                    x.getIamWinMap().forEach((key, value) -> { //стрим результатов игр с заданной командой
                        if (key.getTeamName().equals(nameTeam2)) {
                            System.out.println(value); //печатаем результат игры
                        }
                    });
                }
        );
    }


    //Сравнить две команды по средним баллам и среднему возрасту участников.

    //Найти команды, в которых все участники имеют уникальные имена.
    //Определить команды с самой длинной последовательностью побед.
    //Найти команды с наибольшим количеством ничьих результатов.
    //Выявить команды, которые показали наибольшее улучшение баллов к концу сезона.

    //Создать комплексный отчет, включающий средний возраст команды, общее количество баллов,
    //наибольшую победную серию, и сравнение с другими командами. ++
    public static void complexReport() {
        List<TeamsComplexReport> teamsComplexReports = new ArrayList<>();
        resultGamesMap.entrySet().stream()
                .forEach(t->{
                        teamsComplexReports.add(
                                new TeamsComplexReport(t.getKey().getTeamName(),
                                        t.getKey().getParticipantList().stream().collect(Collectors.averagingDouble(Participant::getAge)),
                                        t.getValue(),t.getKey().getWinnersCount()));
                    }
                    );

        //сравнение по наибольшей победной серии
        teamsComplexReports.stream()
                .sorted(Comparator.comparingInt(TeamsComplexReport::getWinnersCount).reversed())
                .forEach(System.out::println);
    }

} // End of Class

//смотрю....
//        [15:17]
//        сбрасываете winnersCount в ноль, даже если команда не
//        выиграла следующий матч - зачем -> подсчет побед именно подряд !!!
//            Результат максимальный на данный момент записывается перед этим в обьект,
//            далее счетчик обнуляется для поска следующего максимума
//        [15:18]
//        collect(Collectors.averagingInt(Participant::getAge)) - а если список null?
//        [15:18]
//        teamMax - то же самое
//        [15:18]
//        soExpiriens, - результат вычисления где храниться?
//        [15:19]
//        complexReport - аналогично
//        [15:19]
//        а так хорошо