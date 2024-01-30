package lambda;

public class ButtonExample {
    public static void main(String[] args) {
        Button button = new Button();

        button.setClickListener(() -> {
            System.out.println("OK 버튼을 클릭했습니다.");
        });

        button.click();

        Button buttonCancel = new Button();

        buttonCancel.setClickListener(() -> {
            System.out.println("Cancel 버튼을 클릭했습니다. ");
        });

        buttonCancel.click();
    }
}
