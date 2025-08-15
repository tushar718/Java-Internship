import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp extends JFrame {

    // Swing Components
    private DefaultListModel<String> taskListModel; // Stores the tasks
    private JList<String> taskList; // Displays tasks
    private JTextField taskField; // Input field for new tasks
    private JButton addButton, deleteButton; // Action buttons

    public ToDoApp() {
        // JFrame Setup (Main Window)
        setTitle("Java Swing To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Using BorderLayout for main frame
        setLayout(new BorderLayout(10, 10));

        // TOP PANEL: For adding tasks
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout()); // FlowLayout arranges components left to right

        taskField = new JTextField(20);
        addButton = new JButton("Add Task");

        inputPanel.add(taskField);
        inputPanel.add(addButton);

        // CENTER PANEL: For displaying tasks
        taskListModel = new DefaultListModel<>(); // Stores list items
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Only one task can be selected at a time
        JScrollPane scrollPane = new JScrollPane(taskList); // Makes the list scrollable

        // BOTTOM PANEL: For deleting tasks
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        deleteButton = new JButton("Delete Selected");
        bottomPanel.add(deleteButton);

        // Adding panels to frame using BorderLayout
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // EVENT HANDLING: Add Task
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task); // Add task to list
                    taskField.setText(""); // Clear input
                } else {
                    JOptionPane.showMessageDialog(ToDoApp.this, "Please enter a task!");
                }
            }
        });

        // EVENT HANDLING: Delete Selected Task
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(ToDoApp.this, "Please select a task to delete!");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Always run Swing apps on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });
    }
}
