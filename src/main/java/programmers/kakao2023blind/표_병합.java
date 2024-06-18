package programmers.kakao2023blind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 표_병합 {
    Element[][] graph = new Element[51][51];

    public String[] solution(String[] commands) {
        var answer = new ArrayList<String>();
        init();
        for (String command : commands) {
            var split = command.split(" ");
            if (split[0].equals("UPDATE")) {
                if (split.length == 3) {
                    update(split[1], split[2]);
                } else {
                    update(Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]);
                }
            } else if (split[0].equals("MERGE")) {
                merge(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
            } else if (split[0].equals("UNMERGE")) {
                unmerge(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            } else if (split[0].equals("PRINT")) {
                var r = Integer.parseInt(split[1]);
                var c = Integer.parseInt(split[2]);
                if(graph[r][c].currentValue!=null) {
                    answer.add(graph[r][c].currentValue);
                } else {
                    answer.add("EMPTY");
                }
            }
        }
        var answerArray = new String[answer.size()];
        answerArray = answer.toArray(answerArray);
        return answerArray;
    }

    private void init() {
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                graph[i][j] = new Element(null, null, false, new HashSet<>());
            }
        }
    }

    private void update(String before, String after) {
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                if (before.equals(graph[i][j].currentValue)) {
                    graph[i][j].currentValue = after;
                }
            }
        }
    }

    private void update(int r, int c, String value) {
        if(graph[r][c].merged) {
            for (Element element : graph[r][c].mergedElements) {
                element.currentValue = value;
            }
        } else {
            graph[r][c].currentValue = value;
        }
    }

    private void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }
        if (graph[r1][c1].merged && graph[r2][c2].merged) {
            var set1 = graph[r1][c1].mergedElements;
            var set2 = graph[r2][c2].mergedElements;
            if (set1 == set2) {
                return;
            }
            var newSet = new HashSet<Element>();
            newSet.addAll(set1);
            newSet.addAll(set2);
            var value = graph[r1][c1].currentValue != null
                        ? graph[r1][c1].currentValue
                        : graph[r2][c2].currentValue;
            for (Element element : newSet) {
                element.mergedElements = newSet;
                element.currentValue = value;
            }
        } else if (graph[r1][c1].merged) {
            graph[r2][c2].mergedElements = graph[r1][c1].mergedElements;
            graph[r1][c1].mergedElements.add(graph[r2][c2]);
            graph[r2][c2].merged = true;
            var value = graph[r1][c1].currentValue != null
                        ? graph[r1][c1].currentValue
                        : graph[r2][c2].currentValue;
            for (Element element : graph[r1][c1].mergedElements) {
                element.currentValue = value;
            }
        } else if (graph[r2][c2].merged) {
            graph[r1][c1].mergedElements = graph[r2][c2].mergedElements;
            graph[r2][c2].mergedElements.add(graph[r1][c1]);
            graph[r1][c1].merged = true;
            var value = graph[r1][c1].currentValue != null
                        ? graph[r1][c1].currentValue
                        : graph[r2][c2].currentValue;
            for (Element element : graph[r1][c1].mergedElements) {
                element.currentValue = value;
            }
        } else {
            var newSet = new HashSet<Element>();
            newSet.add(graph[r1][c1]);
            newSet.add(graph[r2][c2]);
            graph[r1][c1].mergedElements = newSet;
            graph[r2][c2].mergedElements = newSet;
            graph[r1][c1].merged = true;
            graph[r2][c2].merged = true;
            var value = graph[r1][c1].currentValue != null
                        ? graph[r1][c1].currentValue
                        : graph[r2][c2].currentValue;
            for (Element element : graph[r1][c1].mergedElements) {
                element.currentValue = value;
            }
        }
    }

    private void unmerge(int r, int c) {
        if (!graph[r][c].merged) {
            return;
        }
        var value = graph[r][c].currentValue;
        for (Element element : graph[r][c].mergedElements) {
            element.merged = false;
            element.mergedElements = new HashSet<>();
            element.currentValue=null;
        }
        graph[r][c].currentValue=value;
    }


    class Element {
        String valueBeforeMerge;
        String currentValue;
        boolean merged;
        Set<Element> mergedElements;

        public Element(String valueBeforeMerge, String currentValue, boolean merged, Set<Element> mergedElements) {
            this.valueBeforeMerge = valueBeforeMerge;
            this.currentValue = currentValue;
            this.merged = merged;
            this.mergedElements = mergedElements;
        }
    }
}
