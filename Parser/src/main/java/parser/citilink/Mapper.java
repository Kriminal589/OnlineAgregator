package parser.citilink;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    @NotNull
    public List<String> getVideocard(@NotNull List<WebElement> webElementList) {
        final List<String> output = new ArrayList<>();
        String nameAndFreq = webElementList.get(0).getAttribute("innerText");
        String memory = webElementList.get(1).getAttribute("innerText");

        nameAndFreq = nameAndFreq.substring(nameAndFreq.indexOf(":") + 1);

        String[] params = nameAndFreq.split(", ");

        output.add(params[0].trim().substring(1));
        output.add(params[1].split(" ")[0] + " MHz");
        output.add(memory.split(":")[1].split(" ")[0].substring(1));

        return output;
    }

    @NotNull
    public List<String> getMotherboard(@NotNull List<WebElement> webElementList) {
        final List<String> output = new ArrayList<>();
        String format = webElementList.get(0).getAttribute("innerText");
        String socket = webElementList.get(1).getAttribute("innerText");

        format = format.substring(format.indexOf(":") + 1).replaceAll(";", "");
        socket = socket.substring(socket.indexOf(":") + 1);
        socket = socket.split(";")[0];

        output.add(format);
        output.add(socket);

        return output;
    }
}
