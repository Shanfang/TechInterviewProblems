public boolean isVisable(List<Tape> tapes, Tape red) {
    if (tapes == null || tapes.size() == 0) {
        return true;
    }

    List<Tape> merged = new ArrayList<>();
    Tape pre = tapes.get(0);
    merged.add(pre);
    for (int i = 1; i < tapes.size(); i++) {
        Tape cur = tapes.get(i);
        if (pre.end >= cur.start) {
            pre.end = Math.max(pre.end, cur.end);
        } else {
            merged.add(cur);
            pre = cur;
        }
    }

    // check visiable or not
    for (Tape blue : merged) {
        if (red.start >= blue.start && red.end <= blue.end) {
            return false;
        }
    }
    return true;
}
