package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {
  int compteur_rouge = 0;
  int compteur_vert = 0;
  int compteur_bleu = 0;

  @Override
  public void start(Stage primaryStage) {
    // TODO exercice 6 : implémenter la palette décrite dans la Javadoc.
    //
    // Stratégie conseillée :
    //
    // 1. Créer un BorderPane comme racine.
    //
    // 2. Top : un HBox avec trois boutons "Rouge", "Vert", "Bleu".
    // Donne-leur les ids "btn-rouge", "btn-vert", "btn-bleu" - les tests
    // les retrouvent via robot.lookup("#btn-rouge") etc.
    //
    // 3. Center : un Pane avec l'id "zone", taille minimale 300×200.
    // Change sa couleur via setStyle("-fx-background-color: red;") etc.
    //
    // 4. Bottom : un Label avec l'id "compteurs", texte initial
    // "Rouge: 0 Vert: 0 Bleu: 0".
    //
    // 5. Trois entiers compteur_rouge, compteur_vert, compteur_bleu
    // (ou trois variables d'instance). Chaque clic incrémente le bon
    // compteur et reformate le texte du label.
    //
    // 6. Attention au format du texte du label : les tests vérifient la
    // présence exacte des substrings "Rouge: 2", "Vert: 0", "Bleu: 1"
    // après une séquence de clics.

    BorderPane borderPane = new BorderPane();
    HBox hBox = new HBox();
    Button Rouge = new Button("Rouge");
    Rouge.setId("btn-rouge");
    Button Vert = new Button("Vert");
    Vert.setId("btn-vert");
    Button Bleu = new Button("Bleu");
    Bleu.setId("btn-bleu");
    hBox.getChildren().addAll(Rouge, Vert, Bleu);
    borderPane.setTop(hBox);
    Pane pane = new Pane();
    pane.setId("zone");
    pane.setMinSize(300, 200);
    borderPane.setCenter(pane);
    Label label = new Label("Rouge: 0  Vert: 0  Bleu: 0");
    label.setId("compteurs");
    borderPane.setBottom(label);
    Rouge.setOnAction(
        e -> {
          compteur_rouge += 1;
          pane.setStyle("-fx-background-color: red;");
          label.setText(
              "Rouge: " + compteur_rouge + " Vert: " + compteur_vert + " Bleu: " + compteur_bleu);
        });
    Vert.setOnAction(
        e -> {
          compteur_vert += 1;
          pane.setStyle("-fx-background-color: green;");
          label.setText(
              "Rouge: " + compteur_rouge + " Vert: " + compteur_vert + " Bleu: " + compteur_bleu);
        });
    Bleu.setOnAction(
        e -> {
          compteur_bleu += 1;
          pane.setStyle("-fx-background-color: blue;");
          label.setText(
              "Rouge: " + compteur_rouge + " Vert: " + compteur_vert + " Bleu: " + compteur_bleu);
        });
    Scene scene = new Scene(borderPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
