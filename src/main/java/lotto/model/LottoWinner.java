package lotto.model;

import common.model.Number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinner {

    private final List<LottoNumber> winnerNumbers;

    public LottoWinner(String winnerNumbers) {
        this.winnerNumbers = convert(winnerNumbers);
    }

    private List<LottoNumber> convert(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public void match(LottoNumbers lottoNumbers) {
        Number matchCount = new Number();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            match(lottoNumber, matchCount);
        }
        lottoNumbers.matchRank(matchCount);
    }

    public void match(LottoNumber lottoNumber, Number matchCount) {
        if (contains(lottoNumber)) {
            matchCount.plus();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.winnerNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getWinnerNumbers() {
        return winnerNumbers;
    }
}
