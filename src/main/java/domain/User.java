
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class User {
    private final int MinNumber = 1;
    private final int MaxNumber = 45;
    private final int MinPrice = 1000;
    private final int MaxNumberLength = 6;
    private List<Lotto> createdLotto;
    private List<Integer> checkedLastLotto;
    private HashMap<Integer, Integer> overlap;
    private Scanner Input;

    public int getPrice() {
        Input = new Scanner(System.in);
        int price = 0;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            price = Input.nextInt();
        } while (checkPrice(price));
        return price;
    }

    private boolean checkPrice(int price) {
        if (price < MinPrice) {
            return true;
        }
        return false;
    }

    private int randomNumber() {
        int no = 0;
        do {
            no = (int) (Math.random() * MaxNumber) + MinNumber;
        } while (checkLottoOverlap(no));
        return no;
    }

    private boolean checkLottoOverlap(int no) {
        if (overlap.containsKey(no)) {
            return true;
        }
        overlap.put(no, 0);
        return false;
    }

    public List<Lotto> getLotto(int price) {
        BuyLotto(price);
        System.out.println(createdLotto.size()+"개를 구매했습니다.");
        return createdLotto;
    }

    public List<Integer> getWinningLotto() {
        Input = new Scanner(System.in);
        do {
            overlap = new HashMap<Integer, Integer>();
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String number = Input.nextLine();
            checkedLastLotto = checkLastLotto(number);
        } while (checkLastLottoSize(checkedLastLotto));

        return checkedLastLotto;
    }
}