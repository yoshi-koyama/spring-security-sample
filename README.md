# 概要

このプロジェクトはSpring Security初心者の学習用プロジェクトです

# 前提
- Java 11
- Spring Boot 2.6.3

# Tips
各修正を手で加えるのが面倒！という人は

`$ git checkout {コミットハッシュ}`

でそのコミット時点の状態にすることができます

コミットハッシュはGithubまたは`git log`コマンドから取得可能です

ブランチは`feature/spring-security-complete`に移動しておくことを忘れないでください

Github

https://github.com/yoshi-koyama/spring-security-sample/commits/feature/spring-security-complete

<img width="400" alt="スクリーンショット 2022-02-11 23 35 37" src="https://user-images.githubusercontent.com/62045457/153610937-63e7c2f7-924a-490d-9c85-4deff5c4c781.png">

`git log`コマンド

<img width="400 " alt="スクリーンショット 2022-02-11 23 35 59" src="https://user-images.githubusercontent.com/62045457/153611178-3dc21243-643e-4c01-ae78-2f53eb54c86d.png">


# 作業手順
## プロジェクトをクローンしてブランチを作成する

`$ git clone https://github.com/yoshi-koyama/spring-security-sample.git`

sshでcloneする場合は

`$ git clone git@github.com:yoshi-koyama/spring-security-sample.git`

プロジェクトのルートディレクトリに移動する

`$ cd spring-security-sample`

ブランチを作成して移動する

`$ git branch feature/study-spring-security-{your_name}`

{your_name}: koyama_yoshihito

`$ git checkout feature/study-spring-security-{your_name}`

`$ git status`

## Hello Worldを表示するようにする

修正内容のコミットを参考に修正を加える

https://github.com/yoshi-koyama/spring-security-sample/commit/8c680191bf71aa4a30cb353f5b84bb89250e0ba4

### 動作確認

ターミナルから以下を実行する（IDEから起動してもOK）

`./gradlew bootRun`

パスワードが表示され、アプリケーションが起動していることを確認する

<img width="400" alt="スクリーンショット 2022-02-11 22 59 08" src="https://user-images.githubusercontent.com/62045457/153604659-34b532f2-5ee0-4473-be9e-86cd176d72d8.png">

`localhost:8080/hello`にアクセスしても`http://localhost:8080/login`にリダイレクトされ、ログインページが開かれることを確認する

<img width="400" alt="スクリーンショット 2022-02-11 23 00 40" src="https://user-images.githubusercontent.com/62045457/153604955-555973f4-e7e2-4cba-b481-bd90588fb097.png">

下記を入力して`Sign in`ボタンを押す

Username: `user`

Password: `コンソールに出力されたパスワード`

`localhost:8080/hello`に遷移し、`hello.html`の内容が表示されること

<img width="400" alt="スクリーンショット 2022-02-11 23 03 17" src="https://user-images.githubusercontent.com/62045457/153605496-2f4a9819-6ba2-47e6-b947-0c0726a0a4c2.png">

`logout`リンクを押下するとログアウトの確認画面が表示され、`Log Out`ボタンを押下するとログイン画面が表示されること

<img width="400" alt="スクリーンショット 2022-02-11 23 06 27" src="https://user-images.githubusercontent.com/62045457/153605852-198a24b3-05df-476a-8ded-0410fbc6d4d2.png">

<img width="400" alt="スクリーンショット 2022-02-11 23 06 48" src="https://user-images.githubusercontent.com/62045457/153605894-e92c23b3-4f57-4a2a-a798-a69d0fde44a7.png">

Usernameに`wrong_user`を入力し、`Sign in`ボタンを押すとエラーメッセージとして「ユーザ名かパスワードが正しくありません」が表示されること

<img width="400" alt="スクリーンショット 2022-02-11 23 08 50" src="https://user-images.githubusercontent.com/62045457/153606173-83c22257-a35b-4e96-bc2d-a8705e5e96fd.png">

ターミナルから`ctrl + c`を押下してアプリケーションを終了する

## ログイン処理を追加

修正内容のコミットを参考に修正を加える

https://github.com/yoshi-koyama/spring-security-sample/commit/9a7b58bb2987c680c5e633c62899234de72c4d26

### 動作確認

ターミナルから以下を実行する（IDEから起動してもOK）

`./gradlew bootRun`

アプリケーションが起動していることを確認する

<img width="400" alt="スクリーンショット 2022-02-11 23 12 45" src="https://user-images.githubusercontent.com/62045457/153606850-3c687cff-ce98-424e-b076-4683feacd541.png">

`localhost:8080/hello`にアクセスしても`http://localhost:8080/login`にリダイレクトされ、ログインページが開かれることを確認する

<img width="400" alt="スクリーンショット 2022-02-11 23 13 52" src="https://user-images.githubusercontent.com/62045457/153607037-6004123b-880b-4e6d-ae53-e883ed9625d7.png">

下記を入力して`Login`ボタンを押す

Username: `koyama`

Password: `password_koyama`

`localhost:8080/hello`に遷移し、`hello.html`の内容が表示され、`username is koyama`と表示されること

<img width="400" alt="スクリーンショット 2022-02-11 23 15 34" src="https://user-images.githubusercontent.com/62045457/153607373-d2ebcb21-3109-4322-9dad-28fcd1888e08.png">

`logout`リンクを押下するとログイン画面に遷移すること

下記を入力して`Login`ボタンを押す

Username: `tanaka`

Password: `password_tanaka`

`localhost:8080/hello`に遷移し、`hello.html`の内容が表示され、`username is tanaka`と表示されること

<img width="400" alt="スクリーンショット 2022-02-11 23 17 38" src="https://user-images.githubusercontent.com/62045457/153607705-64042cf6-0ffc-4c2a-9edf-85a53a71802e.png">


下記を入力して`Login`ボタンを押す

Username: `suzuki`

Password: `password_suzuki`

`http://localhost:8080/login?error`に遷移していること
いま時点ではエラーのメッセージが何も表示されないこと

<img width="400" alt="スクリーンショット 2022-02-11 23 18 28" src="https://user-images.githubusercontent.com/62045457/153607973-8f4eab40-40bf-49a5-aa02-ddc00874de7d.png">

ターミナルから`ctrl + c`を押下してアプリケーションを終了する

## エラーメッセージを表示するように変更

修正内容のコミットを参考に修正を加える

https://github.com/yoshi-koyama/spring-security-sample/commit/9f6b3003872c7f0b65838a251918a738c7ca52db

### 動作確認

ターミナルから以下を実行する（IDEから起動してもOK）

`./gradlew bootRun`

アプリケーションが起動していることを確認する

<img width="400" alt="スクリーンショット 2022-02-11 23 21 21" src="https://user-images.githubusercontent.com/62045457/153608316-5d888be2-30c9-4023-851d-fe559f8cf386.png">

下記を入力して`Login`ボタンを押す

Username: `suzuki`

Password: `password_suzuki`

`http://localhost:8080/login?error`に遷移しエラーメッセージが赤字で表示されること

<img width="400" alt="スクリーンショット 2022-02-11 23 22 41" src="https://user-images.githubusercontent.com/62045457/153608533-165283a5-03e2-47e2-8fa4-7335f9eff589.png">

ターミナルから`ctrl + c`を押下してアプリケーションを終了する

## ディレクトリ構成を改善

修正内容のコミットを参考に修正を加える

https://github.com/yoshi-koyama/spring-security-sample/commit/ced335f0730a62dc117aeb6aa2a083c5440e2453

### 動作確認

エラーメッセージを表示するように変更したあとに機能の変更・修正は加えていないため、今までの動作確認手順をもとにアプリケーションを動かしてみる

## Dockerで動作するようにする

修正内容のコミットを参考に修正を加える

https://github.com/yoshi-koyama/spring-security-sample/commit/00130f989824efe3b750c04842e2f2824ef13415

`$ docker-compose up -d`

<img width="400" alt="スクリーンショット 2022-02-11 23 31 50" src="https://user-images.githubusercontent.com/62045457/153610101-9e0b90dc-5277-49ec-9bea-118e52e81817.png">

### 動作確認

エラーメッセージを表示するように変更したあとに機能の変更・修正は加えていないため、今までの動作確認手順をもとにアプリケーションを動かしてみる


