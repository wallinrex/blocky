package com.gamewerks.blocky.engine;

import com.gamewerks.blocky.util.Constants;
import com.gamewerks.blocky.util.Position;
import java.util.Random;

public class BlockyGame {

    private static final int LOCK_DELAY_LIMIT = 30;

    private Board board;
    private Piece activePiece;
    private Direction movement;
    private PieceKind[] pieceArray;
    private int arrayIndex;

    private int lockCounter;

    public BlockyGame() {
        board = new Board();
        movement = Direction.NONE;
        lockCounter = 0;
        pieceArray = PieceKind.ALL;
        arrayIndex = 0;
        trySpawnBlock();
    }

    private PieceKind randomPiece() {
        if (arrayIndex >= pieceArray.length) {
            arrayIndex = 0;
            Random rand = new Random();
            for (int i = pieceArray.length; i > 0; i--) {
                int randInt = rand.nextInt(i);
                PieceKind temp = pieceArray[randInt];
                for (int j = randInt; j < i - 1; j++) {
                    pieceArray[j] = pieceArray[j + 1];
                }
                pieceArray[i - 1] = temp;
            }
        }
        System.out.println(pieceArray[arrayIndex]);
        return pieceArray[arrayIndex++];
    }

    private void trySpawnBlock() {
        if (activePiece == null) {
            activePiece = new Piece(randomPiece(), new Position(1, Constants.BOARD_WIDTH / 2 - 2));
            if (board.collides(activePiece)) {
                System.exit(0);
            }
        }
    }

    private void processMovement() {
        Position nextPos;
        switch (movement) {
            case NONE:
                nextPos = activePiece.getPosition();
                break;
            case LEFT:
                nextPos = activePiece.getPosition().add(0, -1);
                break;
            case RIGHT:
                nextPos = activePiece.getPosition().add(0, 1);
                break;
            default:
                throw new IllegalStateException("Unrecognized direction: " + movement.name());
        }
        if (!board.collides(activePiece.getLayout(), nextPos)) {
            activePiece.moveTo(nextPos);
        }
    }

    private void processGravity() {
        Position nextPos = activePiece.getPosition().add(1, 0);
        if (!board.collides(activePiece.getLayout(), nextPos)) {
            lockCounter = 0;
            activePiece.moveTo(nextPos);
        } else {
            if (lockCounter < LOCK_DELAY_LIMIT) {
                lockCounter += 1;
            } else {
                board.addToWell(activePiece);
                lockCounter = 0;
                activePiece = null;
            }
        }
    }

    private void processClearedLines() {
        board.deleteRows(board.getCompletedRows());
    }

    public void step() {
        trySpawnBlock();
        processMovement();
        processGravity();
        processClearedLines();
    }

    public boolean[][] getWell() {
        return board.getWell();
    }

    public Piece getActivePiece() {
        return activePiece;
    }

    public void setDirection(Direction movement) {
        this.movement = movement;
    }

    public void rotatePiece(boolean dir) {
        Piece test = new Piece(activePiece.getKind(), activePiece.getPosition());
        int currentOrientation = test.getOrientation();
        test.setOrientation(currentOrientation);
        if (dir) {
            test.setOrientation((currentOrientation + 1) % 4);
        } else {
            int k = currentOrientation - 1;
            test.setOrientation(k < 0 ? 3 : k);
        }
        if (!board.collides(test.getLayout(), test.getPosition())) {
            activePiece.rotate(dir);
        }
    }
}
