//import javafx.scene.control.ButtonType;
//import org.controlsfx.dialog.Wizard;
//import org.controlsfx.dialog.WizardPane;
//
//import java.util.Optional;

/**
 * Created by Prigovor on 19.02.2017.
 */
public class MayWizard {
//    public static void main(String[] args) {
//        WizardPane page1 = new WizardPane();
//        WizardPane page2 = new WizardPane();
//        WizardPane page3 = new WizardPane();
//
//        // create wizard
//        Wizard wizard = new Wizard();
//
//        // create and assign the flow
//        wizard.setFlow(new Wizard.LinearFlow(page1, page2, page3));
//
//        // show wizard and wait for response
//        wizard.showAndWait().ifPresent(result -> {
//            if (result == ButtonType.FINISH) {
//                System.out.println("Wizard finished, settings: " + wizard.getSettings());
//            }
//        });
//
//        Wizard.Flow branchingFlow = new Wizard.Flow() {
//            public Optional<WizardPane> advance(WizardPane currentPage) {
//                return Optional.of(getNext(currentPage));
//            }
//
//            public boolean canAdvance(WizardPane currentPage) {
//                return currentPage != page3;
//            }
//
//            private WizardPane getNext(WizardPane currentPage) {
//                if (currentPage == null) {
//                    return page1;
//                } else if (currentPage == page1) {
//                    return page1;
//                }
//                return page2;
//            }
//        };
//    }
}
