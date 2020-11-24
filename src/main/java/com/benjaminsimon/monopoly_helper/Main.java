package main.java.com.benjaminsimon.monopoly_helper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("Monopoly Helper Started");
        PlayerManager manager = new PlayerManager();
        Player bob = manager.addPlayer(new Player("Bob", "blue"));
        Player alf = manager.addPlayer(new Player("Alf", "brown"));
        Player cat = manager.addPlayer(new Player("Cat", "red"));

        if(bob != null) {
            bob.setBankAccount(new BankAccount(200d));
            bob.receive(200d);
        }

        if(alf != null) {
            alf.setBankAccount(new BankAccount(0d));
            alf.receive(100d);
        }

        if(cat != null) {
            cat.setBankAccount(new BankAccount(10d));
            cat.receive(5d);
        }

        System.out.println("============================================================");
        for(Player player : manager.getPlayers()) {
            System.out.println(player.getName() + player.getBankAccount().getAmount());
        }
        manager.removePlayer(bob);
        System.out.println("------------------------------------------------------------");
        for(Player player : manager.sortPlayersByName(true)) {
            System.out.println(player.getName() + player.getBankAccount().getAmount());
        }
        System.out.println("------------------------------------------------------------");
        for(Player player : manager.sortPlayersByMoney(true)) {
            System.out.println(player.getName() + player.getBankAccount().getAmount());
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Monopoly Helper");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
