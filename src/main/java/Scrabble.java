import java.util.HashMap;

public class Scrabble {
    private String word;
    int totalScore;
    static HashMap<Character, Integer> scoreTable = new HashMap<Character,Integer>();
    private Character[] doubleLetter;
    private Character[] tripleLetter;
    private boolean doubleWord;
    private boolean tripleWord;



    public Scrabble(String word) {
        this.word = word;
        this.totalScore =0;
        createScoreTable();
    }

    public Scrabble(String word, Character[] doubleLetter, Character[]tripleLetter, boolean doubleWord, boolean tripleWord){
        this.word=word;
        this.doubleLetter = doubleLetter;
        this.tripleLetter = tripleLetter;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        this.totalScore =0;
        createScoreTable();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Character[] getDoubleLetter() {
        return doubleLetter;
    }

    public void setDoubleLetter(Character[] doubleLetter) {
        this.doubleLetter = doubleLetter;
    }

    public Character[] getTripleLetter() {
        return tripleLetter;
    }

    public void setTripleLetter(Character[] tripleLetter) {
        this.tripleLetter = tripleLetter;
    }

    public Boolean getDoubleWord() {
        return doubleWord;
    }

    public void setDoubleWord(Boolean doubleWord) {
        this.doubleWord = doubleWord;
    }

    public Boolean getTripleWord() {
        return tripleWord;
    }

    public void setTripleWord(Boolean tripleWord) {
        this.tripleWord = tripleWord;
    }

    public int score(){

        if(isWord()){
            normalScore(this.word.toUpperCase());
            doubleLetterScore();
            tripleLetterScore();
            doubleWordScore();
            tripleWordScore();
        }
        return this.totalScore;
    }

    private void normalScore(String word){
        for(char i : word.toCharArray()) {
            Integer score = scoreTable.get(i);
            if (score != null) {
                this.totalScore += score;
            }else{
                this.totalScore =0;
            }
        }
    }

    private void doubleWordScore(){
        if(this.doubleWord && this.totalScore != 0){
            this.totalScore *=2;
        }
    }
    private void tripleWordScore(){
        if(this.tripleWord && this.totalScore != 0){
            this.totalScore *=3;
        }
    }

    private void doubleLetterScore(){
        if(this.doubleLetter !=null){
            for(Character letter : this.doubleLetter){
                this.totalScore += scoreTable.get(letter);
            }
        }
    }

    private void tripleLetterScore(){
        if(this.tripleLetter !=null){
            for(Character letter : this.tripleLetter){
                this.totalScore += scoreTable.get(letter) *2;
            }
        }
    }

    private boolean isWord(){
        return this.word != null;
    }

    private void createScoreTable(){
        scoreTable.put('A', 1);
        scoreTable.put('E', 1);
        scoreTable.put('I', 1);
        scoreTable.put('O', 1);
        scoreTable.put('U', 1);
        scoreTable.put('L', 1);
        scoreTable.put('N', 1);
        scoreTable.put('R', 1);
        scoreTable.put('S', 1);
        scoreTable.put('T', 1);
        scoreTable.put('D', 2);
        scoreTable.put('G', 2);
        scoreTable.put('B', 3);
        scoreTable.put('C', 3);
        scoreTable.put('M', 3);
        scoreTable.put('P', 3);
        scoreTable.put('F', 4);
        scoreTable.put('H', 4);
        scoreTable.put('V', 4);
        scoreTable.put('W', 4);
        scoreTable.put('Y', 4);
        scoreTable.put('K', 5);
        scoreTable.put('J', 8);
        scoreTable.put('X', 8);
        scoreTable.put('Q', 10);
        scoreTable.put('Z', 10);

    }


}
