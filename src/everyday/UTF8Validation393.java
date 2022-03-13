package everyday;

public class UTF8Validation393 {
    public static void main(String[] args) {
        UTF8Validation393 utf8Validation393 = new UTF8Validation393();
        int[] data = {228,189,160,229,165,189,13,10};
        System.out.println(utf8Validation393.validUtf8(data));
    }

    public boolean validUtf8(int[] data) {
        String[] binStrAry = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            StringBuffer binStr = new StringBuffer();
            int dec = data[i];
            while (dec != 0) {
                int mod = dec % 2;
                binStr.append(mod);
                dec = dec / 2;
            }
            if (binStr.length() > 8) {
                return false;
            }
            while (binStr.length() < 8) {
                binStr.append(0);
            }
            binStr.reverse();
            binStrAry[i] = binStr.toString();
        }

        char[] head = binStrAry[0].toCharArray();
        if (binStrAry.length == 1 && !binStrAry[0].startsWith("0"))
            return false;
        int count = 0;
        for (int i = 0; i < head.length; i++) {
            if (head[i] == '0') {
                break;
            } else {
                count++;
            }
        }
        if (count > binStrAry.length || count > 4)
            return false;
        for (int i = 1; i < count; i++) {
            if (!binStrAry[i].startsWith("10")) {
                return false;
            }
        }
        for (int i = count; i < binStrAry.length; i++) {
            if (binStrAry[i].startsWith("10")) {
                return false;
            }
        }
        return true;
    }
}
