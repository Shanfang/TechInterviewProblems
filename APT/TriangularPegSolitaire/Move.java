public class Move {
      private Position start;
      private Position jump;
      private Position end;

      public Move(Position start, Position jump, Position end) {
            this.start = start;
            this.jump = jump;
            this.end = end;
      }

      public Position getStart() { return start; }
      public Position getJump() { return jump; }
      public Position getEnd() { return end; }

      public String toString() {
            StringBuffer sb = new StringBuffer();

            sb.append("{"+start);
            sb.append(","+jump);
            sb.append(","+end+ "}");
            return sb.toString();
      }
}
