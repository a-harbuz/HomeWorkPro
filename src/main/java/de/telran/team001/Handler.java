package de.telran.team001;
import java.util.*;
import java.util.stream.Collectors;

public class Handler {
    private static List<List<Team>> groupTeams = new ArrayList<>(); // All Commands
    private static Map<Team, Double> resultGamesMap = new LinkedHashMap<>(); // All Results

    public static void generate(){
        Generator.generateTeams(groupTeams);
        //Generator.schowTeams(groupTeams);
    }
    public static void play(){
        //Commands play in each Group
        //Если победа то присуждается 1 балл, если ничья 0,5, если проигрыш то 0.
        for (List<Team> teamsList: groupTeams) {
            playInGroup(teamsList);
        }

        //Sort Map by Value
        //Map<Team, Double> tempMap = resultGamesMap.entrySet().stream()
        //.sorted(Map.Entry.<Team, Double>comparingByValue().reversed())

        //.collect(toMap(Function.identity(), Team::));
        //.collect(toMap(Function.identity(), String::length));
        //.forEach(System.out::println);

        //У первой тройки лидеров результаты должны отличаться. Если первые 5 мест одинаковое кол-во баллов,
        //то играют с одинаковыми баллами между собой, пока не определиться тройка лидеров.
        //checkResult(); //проверка первых 5 мест
        //playInGroup(newList); //переиграть

        //showMap();
    }
    public static void playInGroup(List<Team> teamsList){
        //plays in one Group
        for (int i = 0; i < teamsList.size(); i++) {
            double result = 0;
            for (int j = i; j < teamsList.size(); j++) {
                if (i!=j) {
                    double ball = teamsList.get(i).play(teamsList.get(j));
                    result += ball;
                    if (ball==1.0) teamsList.get(i).addiamWin(teamsList.get(j)); //Добавление команд у которых выиграли
                }
            }
            teamsList.get(i).setPunkte(result); //Добавление баллов в класс
            resultGamesMap.put(teamsList.get(i),result);
        }
    }

    public static void showMap(){
        resultGamesMap.entrySet().stream()
                .forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getValue()));
    }

    //================================================================================================
    //Найти команду с максимальными баллами: ++
    public static void teamMax(){
        Optional<Map.Entry<Team, Double>> maxEntry = resultGamesMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.print("Команда с максимальными баллами: ");
        System.out.println(maxEntry.get().getKey().getTeamName() + " : " + maxEntry.get().getValue());

    }

    //Подсчет общего количества баллов: ++
    public static double sumValue(){
        return resultGamesMap.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
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
        for (Map.Entry<Team,Double> m : resultGamesMap.entrySet()){
            List<Participant> lst1 = m.getKey().getParticipantList();
            double sum=0.0;
            for (int i = 0; i < lst1.size(); i++) {
                sum+=lst1.get(i).getAge();
            }
            System.out.println(m.getKey().getTeamName() + " : MidlAge - " + sum/lst1.size());
        }

        //resultGamesMap.keySet().stream()
        //.collect(averagingDouble(m->m.doubleValue()));
        //.map(x -> x.getKey().getParticipantList())
        //.mapToDouble()
        //.sum();

        //.forEach(x->System.out.println(x.getKey().getTeamName() + " : " + x.getValue()));
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
                .sorted(Map.Entry.<Team, Double>comparingByValue().reversed())
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
    public static void whoWin(Team secondTeam) {
        //Team.List<UkogoViigrali>.stream
        //streamList - >фильтр(UkogoViigrali==secondTeam)
        resultGamesMap.keySet().stream()
                .map(x -> x.getIamWinList().stream())
                .forEach(System.out::println);

    }

    //Самый молодой участник среди всех команд:
    public static void soYung(){
        double age= Double.MAX_VALUE;
        for (Map.Entry<Team,Double> m : resultGamesMap.entrySet()){
            List<Participant> lst1 = m.getKey().getParticipantList();
            for (int i = 0; i < lst1.size(); i++) {
                if (lst1.get(i).getAge()<age) age=lst1.get(i).getAge();
            }
        }
        System.out.println("Minimal Age: " + age);

//        resultGamesMap.keySet().stream()
//                .flatMap(x -> x.getParticipantList().stream())
//                .forEach(System.out::println);

    }

    //Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.
    public static void soExpiriens() {
        Map<Team<Participant>,Integer> sumAge = new HashMap<>();
        for (Map.Entry<Team, Double> m : resultGamesMap.entrySet()) {
            List<Participant> lst1 = m.getKey().getParticipantList();
            int age = 0;
            for (Participant participant: lst1) {
                age+=participant.getAge();
            }
            sumAge.put(m.getKey(), age);
        }

        int maxAge = Integer.MIN_VALUE;
        Team<Participant> maxTeam = new Team<>();
        for (Map.Entry<Team<Participant>,Integer> m : sumAge.entrySet()) {
            if (m.getValue()>maxAge) {
                maxAge=m.getValue();
                maxTeam=m.getKey();
            }
        }
        System.out.println("Max Age: " + maxAge);
        System.out.println("MaxAge Team: " + maxTeam.getTeamName());
    }

    //составить список Команда=ср.возраст
    //найти максимум

    //Команды с участниками в определенном возрастном диапазоне:
    //составить список Команда=ср.возраст
    //фильтр по возрасту

    //Имена участников по убыванию возраста:
    //составить список Команда.участники.имя=Команда.участники.возраст
    //сортировка по возрасту

} // End of Class

