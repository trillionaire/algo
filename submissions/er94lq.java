class Solution {
    public boolean isMagic(int[] target) {
        int[] source = new int[target.length];
        for (int i = 0; i < source.length; i++) {
            source[i] = i + 1;
        }
        int[] magic = swap(source);
        int sameLen = compare(magic, target);
        if (sameLen == magic.length) {
            return true;
        } else if (sameLen == 0) {
            return false;
        }
        target = Arrays.copyOfRange(target, sameLen, magic.length);
        magic = Arrays.copyOfRange(magic, sameLen, magic.length);

        while (magic.length > 0) {
            magic = swap(magic);
            if (magic.length <= sameLen) {
                if (compare(magic, target) == magic.length) {
                    return true;
                } else {
                    return false;
                }
            }
            if (compare(magic, target) >= sameLen) {
                target = Arrays.copyOfRange(target, sameLen, magic.length);
                magic = Arrays.copyOfRange(magic, sameLen, magic.length);
            } else {
                return false;
            }
        }
        return true;
    }
    private int compare(int[] source, int[] target) {
        int start = -1;
        for (int i = 0; i < source.length; i++) {
            if (target[i] == source[i]) {
                start = i;
            } else {
                break;
            }
        }
        return start + 1;
    }

    private int[] swap(int[] source) {
        int start = 0;
        int[] magic = new int[source.length];
        for (int i = 1; i < magic.length; i += 2) {
            magic[i / 2] = source[i];
            start++;
        }
        for (int i = 0; i < magic.length; i += 2) {
            magic[i / 2 + start] = source[i];
        }
        return magic;
    }

}