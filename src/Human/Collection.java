package Human;

import java.io.*;
import java.util.*;

import com.google.gson.*;

public class Collection {
    private Hashtable<Integer, HumanBeing> collection = new Hashtable<Integer, HumanBeing>();
    private java.util.Date creationDate = new Date();
    private String name = "def";

    public Collection() {
    }

    public Collection(String name) {
        if (name == null) {
            return;
        }
        this.name = name;
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(name))) {
            int i;
            Scanner scanner = new Scanner(in);
            String str = "";
            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
            }
            scanner.close();
            in.close();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            try {
                collection = gson.fromJson(str, collection.getClass());
                if (collection == null) collection = new Hashtable<Integer, HumanBeing>();
            } catch (JsonSyntaxException e) {
                System.out.println("Ошибка синтаксиса джейсон");
                return;
            }
            System.out.println("Коллекция успешно загружена");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не существует, указана директория или он не может быть открыт");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("Ошибка доступа");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка с закрытием файла");
            System.exit(1);
        }
    }

    public void save() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(collection);
        try {
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка с чтением файла");
        }
    }

    public void insert(Integer k) {
        HumanBeing humanBeing = new HumanBeing();
        humanBeing.create();
        collection.put(k, humanBeing);
    }

    public void pushId(Long id) {
        for (HashMap.Entry<Integer, HumanBeing> entry : collection.entrySet()) {
            if (entry.getValue().getId() == id) {
                HumanBeing humanBeing = new HumanBeing();
                humanBeing.create();
                collection.put(entry.getKey(), humanBeing);
                return;
            }
        }
        System.out.println("Id эллемента не существует");
    }

    public void ril(Integer k) {
        HumanBeing humanBeing = new HumanBeing();
        humanBeing.create();
        try {
            if (collection.get(k).compareTo(humanBeing) < 0) collection.put(k, humanBeing);
        } catch (NullPointerException e) {
            System.out.println("Объект по указанному ключу не существует");
        }
    }

    public void remove(Integer k) {
        try {
            collection.remove(k);
        } catch (UnsupportedOperationException e) {
            System.out.println("Не существовало элемента с данным ключом");
        }
    }

    public void clear() {
        collection = new Hashtable<Integer, HumanBeing>();
    }


    public String getInfo() {
        String info;
        info = collection.getClass().getName() + "\n" + creationDate.toString() + "\n" + collection.size();
        return info;
    }

    public String getElements() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(collection);
    }

    public double average() {
        double i = 0, k = 0;
        for (HashMap.Entry<Integer, HumanBeing> entry : collection.entrySet()) {
            i += entry.getValue().getImpact();
            k++;
        }
        return i / k;
    }

    public String filterName(String name) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String str = "";
        for (HashMap.Entry<Integer, HumanBeing> entry : collection.entrySet()) {
            if (entry.getValue().getName().startsWith(name)) {
                str += (gson.toJson(entry.getValue()) + "\n");
            }
        }
        return str;
    }

    public String filterImpact(long impact) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String str = "";
        for (HashMap.Entry<Integer, HumanBeing> entry : collection.entrySet()) {
            if (entry.getValue().getImpact() > impact) {
                str += (gson.toJson(entry.getValue()) + "\n");
            }
        }
        return str;
    }
}
//gson.toJson(new Human.HumanBeing());