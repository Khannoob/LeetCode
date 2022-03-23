package everyday;

public class RemoveColoredPieces2038 {
    public static void main(String[] args) {

    }

    public boolean winnerOfGame(String colors) {
        char[] chars = colors.toCharArray();
        int count = 0;
        //通过计数来
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i - 1] == 'A' && chars[i] == 'A' && chars[i + 1] == 'A') {
                count++;
                continue;
            }
            if (chars[i - 1] == 'B' && chars[i] == 'B' && chars[i + 1] == 'B') {
                count--;
            }
        }
        return count > 0;
    }
}
