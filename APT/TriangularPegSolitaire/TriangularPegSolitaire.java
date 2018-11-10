// https://www.codeproject.com/Articles/272466/Triangle-Peg-Solitaire
class TriangularPegSolitaire {
    DepthFirstSearch(Board b, Peg start)
    {
          If (Grandchild.isEmpty())
                Jump();
                updateBoard(); //updates empty peg, location, etc.
          else
                backtrack();  // backtrack to previous and/or try right child
    }

    // game board
    public List<GameBoard> possibleBoards() {
                List<GameBoard> boards = new ArrayList<GameBoard>();

                for (int i = 0; i < 5; ++i)
                      for (int j = 0; j <= i; ++j) {
                            Position start = new Position(i,j);
                            List<Move> possibleMoves = Moves.getMoves(start);
                            for (Move move : possibleMoves) {
                                  if (validMove(move))
                                        boards.add(jump(move));
                            }
    			}
    	return boards;
    }   
}
