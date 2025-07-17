//問題1を選択
import java.util.Random;//1行目から43行目山田作成
import java.util.Scanner;

public class Janken {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== じゃんけん勝負アプリ ===");
        System.out.print("プレイヤーの名前を入力してください: ");
        String playerName = scanner.nextLine();

        int winCount = 0;
        int loseCount = 0;
        int drawCount = 0;

        String[] hands = {"グー", "チョキ", "パー"};

        while (true) {
            System.out.println("\n" + playerName + " の手を選んでください（0: グー, 1: チョキ, 2: パー, 9: 終了）:");
            int playerChoice;
            try {
                playerChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("数字で入力してください。");
                continue;
            }

            if (playerChoice == 9) {
                System.out.println("ゲームを終了します。");
                break;
            }

            if (playerChoice < 0 || playerChoice > 2) {
                System.out.println("無効な入力です。0〜2の数字を入力してください。");
                continue;
            }

            int computerChoice = random.nextInt(3);

            System.out.println(playerName + " の手: " + hands[playerChoice]);
            System.out.println("コンピュータの手: " + hands[computerChoice]);

            // 勝敗判定　45行目から61行目島田作成
            if (playerChoice == computerChoice) {
                System.out.println("結果: あいこです！");
                drawCount++;
            } else if ((playerChoice == 0 && computerChoice == 1) ||
                       (playerChoice == 1 && computerChoice == 2) ||
                       (playerChoice == 2 && computerChoice == 0)) {
                System.out.println("結果: 勝ち！");
                winCount++;
            } else {
                System.out.println("結果: 負け...");
                loseCount++;
            }

            // スコア表示
            System.out.println("現在のスコア → 勝ち: " + winCount + ", 負け: " + loseCount + ", あいこ: " + drawCount);
        }

        // 最終結果　63行目から68行目山田作成
        System.out.println("\n=== 最終結果 ===");
        System.out.println("プレイヤー: " + playerName);
        System.out.println("勝ち: " + winCount + "回");
        System.out.println("負け: " + loseCount + "回");
        System.out.println("あいこ: " + drawCount + "回");
        scanner.close();
    }
}

