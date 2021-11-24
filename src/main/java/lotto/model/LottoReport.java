package lotto.model;

import common.model.Number;

import java.util.HashMap;
import java.util.Map;

public class LottoReport {

    private final Map<LottoRank, Number> lottoRankNumbers;

    public LottoReport(Lotto lotto, LottoWinner winner) {
        this.lottoRankNumbers = initialize();
        match(lotto, winner);
    }

    private Map<LottoRank, Number> initialize() {
        Map<LottoRank, Number> lottoRankNumberMap = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoRankNumberMap.put(rank, new Number());
        }
        return lottoRankNumberMap;
    }

    private void match(Lotto lotto, LottoWinner winner) {
        for (LottoNumbers lottoNumbers : lotto.getLotto()) {
            countPlus(winner.match(lottoNumbers));
        }
    }

    private void countPlus(LottoRank rank) {
        Number count = lottoRankNumbers.get(rank);
        count.plus();
        lottoRankNumbers.put(rank, count);
    }

    public float calculateRateOfRevenue(int purchaseAmount) {
        float revenue = 0;

        for (LottoRank rank : LottoRank.valuesWithoutMiss()) {
            Number count = lottoRankNumbers.get(rank);
            revenue += rank.getAmount() * count.getNumber();
        }

        return Math.round(revenue / purchaseAmount * 100) / 100.F;
    }

    public Map<LottoRank, Number> getLottoRankNumbers() {
        return lottoRankNumbers;
    }
}
