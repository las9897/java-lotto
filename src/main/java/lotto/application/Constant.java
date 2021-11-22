package lotto.application;

public class Constant {

    public static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_MESSAGE_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public static final String OUTPUT_MESSAGE_PURCHASE_LOTTO = "개를 구매했습니다.";

    public static final String EXCEPTION_MESSAGE_LENGTH_VALIDATION = "당첨 번호가 6개가 아닙니다.";
    public static final String EXCEPTION_MESSAGE_DUPLICATE_VALIDATION = "중복되는 당첨 번호가 있습니다.";
    public static final String EXCEPTION_MESSAGE_RANGE_VALIDATION = "로또 번호는 1~45 사이의 숫자입니다.";
    public static final String EXCEPTION_MESSAGE_PARSE_VALIDATION = "숫자가 아닌 문자가 입력되었습니다.";

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private Constant() {
    }

}
