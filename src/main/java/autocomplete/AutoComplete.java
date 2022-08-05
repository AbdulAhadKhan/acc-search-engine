package autocomplete;

import java.io.*;
import java.util.List;

public class AutoComplete {
    Trie wordTrie;

    public AutoComplete(String path) throws IOException {
        String line;
        wordTrie = new Trie();

        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((line = reader.readLine()) != null)
            wordTrie.insert(line);
    }

    public List<String> suggest(String prefix) {
        if (prefix.isEmpty()) return List.of();
        return wordTrie.suggest(prefix);
    }
}
