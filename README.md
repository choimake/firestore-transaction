# firestore-transaction
Firestoreを活用したRepositoryパターンにおいて、UseCase層でトランザクションを実行する方法を実装したもの

## How to use
### 前提
- Google Cloudのプロジェクトを用意すること
- 上記プロジェクトと連携した、Firebaseのプロジェクトを用意すること
- Google Cloudのプロジェクトにgcloudでログインしておくこと
- direnvを導入しておくこと（環境変数を自前で設定する方法でもOK）

### 手順
- .env.exampleを元に.evnファイルを作成する
- .envファイルのプロジェクトIDを使用するプロジェクトIDに書き換える
- 動かす
