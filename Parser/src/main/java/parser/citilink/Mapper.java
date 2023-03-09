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

        output.add(format.substring(1));
        output.add(socket.substring(1));

        return output;
    }

    @NotNull
    public String getPowerSupply(@NotNull List<WebElement> webElementList) {
        String power = webElementList.get(0).getAttribute("innerText");

        return power.substring(power.indexOf(":") + 2, power.indexOf(","));
    }

    @NotNull
    public List<String> getProcessor(@NotNull List<WebElement> webElementList) {
        final List<String> output = new ArrayList<>();
        String core = webElementList.get(0).getAttribute("innerText");
        String socket = webElementList.get(2).getAttribute("innerText");

        core = core.substring(core.indexOf(":") + 2).replaceAll(";", "");
        socket = socket.substring(socket.indexOf(":") + 2).replaceAll(";", "");

        output.add(core);
        output.add(socket);

        return output;
    }

    @NotNull
    public List<String> getRAM(@NotNull String title) {
        try {
            final List<String> output = new ArrayList<>();
            int index = title.indexOf("DDR");
            String name = title.substring(0, index - 1);
            String type = title.substring(index, index + 4);
            String info = title.substring(title.lastIndexOf("-  ") + 3);
            info = info.substring(0, info.indexOf(","));
            String frequency = info.substring(info.toCharArray().length - 5);
            String memory = info.substring(0, info.toCharArray().length - 5);

            output.add(name);
            output.add(type);
            output.add(memory);
            output.add(frequency);

            return output;
        } catch (Exception e) {
            System.out.println(title);
            throw new RuntimeException();
        }
    }

    @NotNull
    public String getRomHDD(@NotNull List<WebElement> webElementList) {
        String memory = webElementList.get(0).getAttribute("innerText");

        return memory.substring(memory.indexOf(":") + 2).replace(";", "");
    }
}
