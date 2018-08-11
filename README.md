# GradeChecker
発展プログラミング演習、最終課題の解答（https://ksuap.github.io/2018spring/lesson14/）

## DDDで設計

## 手を抜いた所
- ドメインオブジェクトにビジネスロジックを実装せず、全てServiceに委譲している。
- ServiceのInterfaceを定義していない。
- コレクションにはTreeMapではなくTreeSetを利用するべき。
- CalculatedScoreをEntityにしていない。
- テストを書いていない。