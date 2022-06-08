# dijkstara

kotlinでダイクストラ法を実装

## 現在の進捗

- getShortestPath(startNode: Int)
  - スタートノードから各ノードへのの最短経路を出力

- getShortestPath(startNode: Int, goalNode: Int)
  - スタートノードからゴールノードへの最短経路を出力

- getShortestPathCost(startNode: Int, goalNode: Int)
  - スタートノードからゴールノードへの最短経路のコストを出力

- 条件は入力から受け取れる
  - 1行目 (n, m) n: ノードの個数, m: エッジの個数
  - 以下m行 (a, b, c) a: エッジの始まり, b: エッジの行き先, c: cost

## 今後やること
 - リファクタリング
