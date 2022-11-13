package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedList;

public class LottoApplication {
    private LottoController lc = new LottoController();

    private LinkedList<Lotto> lottoPool;
    private ArrayList<Integer> winNumber;
    private int bonusNumber = 0;

    public static void main(String[] args) {
        LottoApplication lp = new LottoApplication();
        lp.run();
    }

    public void run(){
        System.out.println("구입금액을 입력해 주세요.");

        int lottoAmount = lc.readUserMoney(Console.readLine())/1000;

        System.out.println("\n"+lottoAmount+"개를 구매했습니다.");
        lc.createRandomLotto(lottoAmount);

        this.lottoPool = lc.createRandomLotto(lottoAmount);
        this.printLottoPool();
    }


    public void printLottoPool() {
        for (Lotto lotto : lottoPool) {
            System.out.println(lotto.toString());
        }
    }
}
