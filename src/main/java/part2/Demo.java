package part2;

import part2.model.Player;
import part2.model.Team;

import java.util.Collection;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        Team teamC = new Team("teamC");

        Player player1 = new Player("player1", 19);
        Player player2 = new Player("player2", 20);
        Player player3 = new Player("player3", 21);
        Player player4 = new Player("player4", 22);
        Player player5 = new Player("player5", 23);
        Player player6 = new Player("player6", 24);
        Player player7 = new Player("player7", 25);

        teamA.addPlayer(player1);
        teamA.addPlayer(player2);
        teamA.addPlayer(player3);

        teamB.addPlayer(player4);
        teamB.addPlayer(player5);

        teamC.addPlayer(player6);
        teamC.addPlayer(player7);

        List<Team> teams = List.of(teamA, teamB, teamC);


        printTeamNamesStartingWithTraditional(teams, "team");
        printTeamNamesStartingWith(teams, "team");

        printPlayersAgedGreaterThan20Conventional(teams);
        printPlayersAgedGreaterThan20(teams);


        printCartesianProduct(List.of("1", "2", "3"), List.of("A", "B"));
        printCartesianProductTraditional(List.of("1", "2", "3"), List.of("A", "B"));

        printSquareOfOddElementsInTheGivenListOfLists(List.of(List.of(1, 2, 3), List.of(4, 5, 6)));
        printSquareOfOddElementsInTheGivenListOfListsTraditional(List.of(List.of(1, 2, 3), List.of(4, 5, 6)));
    }

    private static void printTeamNamesStartingWithTraditional(List<Team> teams, String prefix) {
        for (Team team : teams) {
            String teamName = team.getName();
            if (teamName.startsWith(prefix)) {
                System.out.println(team.getName());
            }
        }
    }

    private static void printTeamNamesStartingWith(List<Team> teams, String prefix) {
        teams
                .stream()
                .map(Team::getName)
                .filter(name -> name.startsWith(prefix))
                .forEach(System.out::println);
    }


    private static void printPlayersAgedGreaterThan20Conventional(List<Team> teams) {
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (player.getAge() > 20) {
                    System.out.println(player);
                }
            }
        }
    }

    private static void printPlayersAgedGreaterThan20(List<Team> teams) {
        teams
                .stream()
                .flatMap(team -> team.getPlayers().stream())
                .filter(player -> player.getAge() > 20)
                .forEach(System.out::println);
    }

    private static void printCartesianProductTraditional(List<String> list1, List<String> list2) {
        for (String str1 : list1) {
            for (String str2 : list2) {
                System.out.println(str1 + " " + str2);
            }
        }
    }

    private static void printCartesianProduct(List<String> list1, List<String> list2) {
        list1.stream()
                .flatMap(e1 -> list2.stream().map(e2 -> new String[]{e1, e2}))
                .forEach(arr -> System.out.println(arr[0] + " " + arr[1]));
    }

    private static void printSquareOfOddElementsInTheGivenListOfListsTraditional(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            for (Integer i : l) {
                if (i % 2 != 0) {
                    System.out.println(i * i);
                }
            }
        }
    }

    private static void printSquareOfOddElementsInTheGivenListOfLists(List<List<Integer>> lists) {
        lists.stream()
                .flatMap(Collection::stream)
                .filter(i -> i % 2 != 0)
                .map(i -> i * i)
                .forEach(System.out::println);
    }
}
