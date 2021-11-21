package common.view;

import common.model.Number;
import lotto.application.Constant;
import lotto.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String... messages) {
        StringBuilder builder = new StringBuilder();
        for (String message : messages) {
            builder.append(message);
        }
        print(builder.toString());
    }

    public static void print(int message) {
        System.out.println(message);
    }

    public static void print(Number number) {
        print(number.getNumber());
    }

    public static void print(List<LottoNumber> lottoNumbers) {

        List<String> lottoNumbersString = lottoNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        print("[", String.join(", ", lottoNumbersString), "]");

    }

    public static void print(Lotto lotto) {
        OutputView.print(String.valueOf(lotto.getLotto().size()), Constant.OUTPUT_MESSAGE_PURCHASE_LOTTO);
        for (LottoNumbers lottoNumbers : lotto.getLotto()) {
            print(lottoNumbers.getLottoNumbers());
        }
    }

    public static void print(LottoStats lottoStats) {
        print("당첨 통계");
        print("-------------");

        //일치여부 확인
        Map<LottoRank, Number> lottoRankNumberMap = lottoStats.getLottoRankNumberMap();
        for (LottoRank rank : LottoRank.valuesWithoutMiss()) {
            Number count = lottoRankNumberMap.getOrDefault(rank, new Number());
            print(String.valueOf(rank.getMatchCount()), "개 일치 (", String.valueOf(rank.getAmount()), "원)- ",
                    count.toString(), "개");
        }

        //총 수익률
        print("총 수익률은 ", String.valueOf(lottoStats.getRateOfRevenue()), "입니다.");

    }
}
