import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        // Verifica se o usuário passou a URL como argumento
        if (args.length < 1) {
            System.out.println("Por favor, insira uma URL como argumento.");
            return;
        }

        // Obtém a URL passada como argumento
        String url = args[0];

        // Obtém o conteúdo HTML da URL
        String html = getHtmlFromUrl(url);

        // Encontra o texto mais profundo no HTML
        String deepestText = findDeepestText(html);

        // Imprime o texto mais profundo encontrado
        System.out.println(deepestText);
    }

    private static String getHtmlFromUrl(String urlString) {
        // Obtém o conteúdo HTML a partir de uma URL
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlString);

            // Estabelece a conexão com a URL
            URLConnection conn = url.openConnection();

            // Obtem o HTML
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            // Lê e adiciona linha por linha do HTML caso não seja nula
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();

            // Caso haja falha de conexão, retorna um error
        } catch (IOException e) {
            System.out.println("URL connection error");
        }
        return sb.toString();
    }

    private static String findDeepestText(String html) {
        // Encontra o texto mais profundo no HTML
        String deepestText = "";
        int deepestLevel = -1;
        int currentLevel = 0;
        boolean foundAtMaxDepth = false;

        // Remove todas as tags do HTML e cria um array de tags
        String[] tags = html.replaceAll("(?s)<!--.*?-->", "").split("<");

        // Percorre todas as tags
        for (String tag : tags) {

            if (tag.isEmpty()) {
                continue;
            }

            // Verifica se é uma tag de abertura ou fechamento
            boolean isOpeningTag = true;
            if (tag.startsWith("/")) {
                isOpeningTag = false;
                tag = tag.substring(1);
            }

            // Separa o nome da tag dos atributos
            String[] tagParts = tag.split(">", 2);
            String tagContent = tagParts[1];
            // Verifica o nível da tag
            if (isOpeningTag) {
                currentLevel++;
                if (currentLevel > deepestLevel) {
                    deepestLevel = currentLevel;
                    deepestText = "";
                    foundAtMaxDepth = false;
                }
            } else {
                currentLevel--;
            }

            // Verifica se a tag contém texto
            if (!tagContent.isEmpty()) {
                // Verifica se o nível é o mais profundo até o momento
                if (currentLevel == deepestLevel) {
                    // Remove todas as tags dentro da string e adiciona o texto mais profundo
                    // encontrado
                    String text = tagContent.replaceAll("(?s)<.*?>", "").trim();
                    if (!text.isEmpty() && !foundAtMaxDepth) {
                        deepestText = text;
                        foundAtMaxDepth = true;
                    }
                }
            }
        }
        // Quando o currentLevel é diferente de 0, indica que há diferença entre a
        // quantidade de tags abertas e fechadas
        if (currentLevel != 0) {
            deepestText = "malformed HTML";
            return deepestText;
        } else
            return deepestText;
    }
}
