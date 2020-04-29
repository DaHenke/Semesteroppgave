package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javafx.scene.control.TableView;

public class PCRegister implements Serializable {
    private static final long serialVersionUID = 1;

    private transient ObservableList<Part> pregister = FXCollections.observableArrayList();

    public List<Part> getRegister(){return pregister;}

    public void addPart(Part p){pregister.add(p);}

    public void removeAll(){pregister.clear();}

    public ObservableList<Part> getArray(){
        return this.pregister;
    }

    public void attachTableView(TableView tv){tv.setItems(pregister);}

    public Part searchRegisterByName(String name){
        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);

        for(Part p : pregister){
            Matcher matcher = pattern.matcher(p.getDelNavn());

            if(matcher.find()){
                return p;
            }
        }
        return null;
    }

    public ObservableList<Part> filterByName(String name){
        return pregister.stream().
                filter(p -> p.getDelNavn().toLowerCase().
                        matches(String.format("%s%s%s",".*",name.toLowerCase(),".*"))).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<Part> filterByType(String type){
        return pregister.stream().
                filter(p -> p.getType().toLowerCase().
                        matches(String.format("%s%s%s",".*",type.toLowerCase(),".*"))).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public ObservableList<Part> filterByPrice(int price){
        return pregister.stream().
                filter(p -> p.getDelPris() == price).
                collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Part p : pregister){
            sb.append(p.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeObject(new ArrayList<>(pregister));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        List<Part> list = (List<Part>) s.readObject();
        pregister = FXCollections.observableArrayList();
        pregister.addAll(list);
    }
}
