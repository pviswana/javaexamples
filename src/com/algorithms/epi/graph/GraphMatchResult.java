package com.algorithms.epi.graph;

import java.util.*;

public class GraphMatchResult {
    public boolean canTeamABeatTeamB(List<MatchResult> matches, String teamA, String teamB) {
        Set<String> visited = new HashSet<>();
        return isReachableDFS(buildGraph(matches), teamA, teamB, visited);
    }

    private boolean isReachableDFS(Map<String, Set<String>> graph, String curr,
                                   String dest, Set<String> visited) {
        if (curr.equals(dest)) {
            return true;
        }

        if (visited.contains(curr) || graph.get(curr) == null) {
            return false;
        }

        visited.add(curr);
        System.out.println(curr);

        for (String team : graph.get(curr)) {
            if (isReachableDFS(graph, team, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, Set<String>> buildGraph(List<MatchResult> matches) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (MatchResult matchResult : matches) {
            Set<String> edges = graph.get(matchResult.winningTeam);
            if (edges == null) {
                edges = new HashSet<>();
                graph.put(matchResult.winningTeam,edges );
            }
            edges.add(matchResult.losingTeam);
        }
        return graph;
    }

    public static void main(String[] args) {
        List<MatchResult> matches = new ArrayList<>();
        matches.add(new MatchResult("A", "B"));
        matches.add(new MatchResult("B", "C"));
        matches.add(new MatchResult("C", "D"));
        matches.add(new MatchResult("E", "D"));

        GraphMatchResult graphMatchResult = new GraphMatchResult();
        boolean result = graphMatchResult.canTeamABeatTeamB(matches,"A" , "E");
        System.out.println(result);
    }
}

class MatchResult {
    public String winningTeam;
    public String losingTeam;

    public MatchResult(String winningTeam, String losingTeam) {
        this.winningTeam = winningTeam;
        this.losingTeam = losingTeam;
    }
}


