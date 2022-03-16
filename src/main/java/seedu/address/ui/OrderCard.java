package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.order.Order;

/**
 * An UI component that displays information of an {@code Order}.
 */
public class OrderCard extends UiPart<Region> {

    private static final String FXML = "OrderListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Order order;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label customerName;
    @FXML
    private Label customerPhone;
    @FXML
    private Label driverName;
    @FXML
    private Label dishes;
    @FXML
    private Label status;
    @FXML
    private Label orderNumber;

    /**
     * Creates a {@code orderCode} with the given {@code order} and index to display.
     */
    public OrderCard(Order order, int displayedIndex) {
        super(FXML);
        this.order = order;
        id.setText(displayedIndex + ". ");
        orderNumber.setText("#" + order.getOrderNumber());
        customerName.setText(order.getCustomerName());
        customerPhone.setText(order.getCustomerPhone());
        driverName.setText(order.getDriverName());
        dishes.setText(order.getDishes().toString()); // todo if necessary, use a better toString representation
        status.setText(order.getStatus().toString());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof OrderCard)) {
            return false;
        }

        // state check
        OrderCard card = (OrderCard) other;
        return orderNumber.getText().equals(card.orderNumber.getText())
                && order.equals(card.order);
    }
}