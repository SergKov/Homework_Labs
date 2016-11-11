package homework2.task2;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 08.11.2016.
 */
public class Text implements Cloneable {

    private static final String DOT = ".";
    private static final String SPACE = " ";
    private static final int OFFSET = 50;

    private String title;
    private List<Sentence> sentences;

    public Text() { }

    public Text(String title, List<Sentence> sentences) {
        this.title = title;
        this.sentences = sentences;
    }

    public void addSentence(final Sentence sentence) {
        sentences.add(sentence);
    }

    public void printTitle() {
        System.out.println(StringUtils.center(title, title.length() + OFFSET));
    }

    public void printAllText() {
        System.out.println(toString());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        final Text text = (Text) super.clone();

        if (!CollectionUtils.isEmpty(sentences)) {
            final List<Sentence> sentencesClone = new ArrayList<>();
            for (final Sentence sentence: sentences) {
                sentencesClone.add((Sentence) sentence.clone());
            }
            text.setSentences(sentencesClone);
        }

        return text;
    }

    @Override
    public String toString() {
        final StringBuilder text = new StringBuilder();
        text.append(StringUtils.center(title, title.length()));
        sentences.forEach(text::append);
        return text.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (title != null ? !title.equals(text.title) : text.title != null) return false;
        return sentences != null ? sentences.equals(text.sentences) : text.sentences == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (sentences != null ? sentences.hashCode() : 0);
        return result;
    }

    public static class Sentence implements Cloneable {

        private List<Word> words;

        public Sentence() {
            words = new ArrayList<>();
        }

        public Sentence(List<Word> words) {
            this.words = words;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            final Sentence sentence = (Sentence) super.clone();

            if (!CollectionUtils.isEmpty(words)) {
                final List<Word> wordsClone = new ArrayList<>();
                for (final Word word : words) {
                    wordsClone.add((Word) word.clone());
                }
                sentence.setWords(wordsClone);
            }

            return sentence;
        }

        @Override
        public String toString() {
            final StringBuilder sentence = new StringBuilder();

            words.forEach(word -> {
                sentence.append(word);
                sentence.append(SPACE);
            });

            sentence.append(DOT);

            return sentence.toString();
        }

        public List<Word> getWords() {
            return words;
        }

        public void setWords(List<Word> words) {
            this.words = words;
        }
    }

    public static class Word implements Cloneable {

        private String value;

        public Word() { }

        public Word(String value) {
            this.value = value;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
