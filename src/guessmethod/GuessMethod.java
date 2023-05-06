 
package guessmethod;

 import javax.swing.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.awt.event.*;
 import java.text.DecimalFormat;

public class GuessMethod extends JFrame{

    JTextField[][] field = new JTextField[10][10];
    JTextField[]  xfield = new JTextField[10];
    double[][] a = new double[10][10];
    double[]  b = new double [10];
    double[]  x = new double [10];
    double[]  y = new double [10];
    String[][] st =new String[100][100];
    
    static int n,m,counter=0,row=0,col=0;
    JButton compute;
    JTextField mx,dp;
    
    GuessMethod(){
        super("Guess Calculator");
          
          JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER,15,15));
          JLabel l1 = new JLabel("Enter the matrix Rowwise");
          l1.setFont(new Font("Serif",3,20));
          p1.add(l1);
          
          JPanel p2 = new JPanel(new GridLayout(n,(n+1)));
          p2.setBorder(new LineBorder(Color. GRAY,1));
                   
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            field[i][j] = new JTextField(10);
            field[i][j].setText("");
        }
    }
          for(int i=0;i<n;i++){ 
             p2.add(new JLabel("R"+(i+1))); 
             for(int j=0;j<(n+1);j++){  
                field[i][j] = new JTextField(10);
                p2.add( field[i][j]);
             }
          }
          JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,25));
          p3.add(new JLabel("Guess value"));
          for(int i=0;i<n;i++){ 
              p3.add(new JLabel("x"+(i+1)));
              xfield[i]  = new JTextField(5);
                p3.add( xfield[i]);
          }
          
          
          compute = new JButton("Compute");
          compute.setFont(new Font("Serif",3,20));
           dp = new JTextField(7);
           
           p3.add(new JLabel("D.P"));
           p3.add(dp);
         p3.add(new JLabel("NO. of iteration"));
         mx = new JTextField(7);
          p3.add(mx);
          JPanel p33 = new JPanel();
          p33.add(p3,BorderLayout.CENTER);
          p33.add(compute,BorderLayout.SOUTH);
          add(p1,BorderLayout.NORTH);
          add(p2,BorderLayout.WEST);
          add(p33,BorderLayout.SOUTH);
          
          compute.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
               int z=0; 
               m= Integer.parseInt(mx.getText());
         for(int i=0;i<n;i++){ 
               x[i]  = Double.parseDouble(xfield[i] .getText());
             for(int j=0;j<(n+1);j++){  
                 
                if(j==n){
                     b[z] = Double.parseDouble(field[i][j].getText());
                     z++;
                }
                else{
                     a[i][j] = Double.parseDouble(field[i][j].getText());
                }
             }
          }
        /* JFrame frame = new   JFrame("Tabel for Guess Method");

        frame.setSize(650, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JPanel p1 =new JPanel(new GridLayout(0,2));*/
          while( m >0){
               st[row][col]= String.valueOf((row+1));
              for(int i=0;i<n;i++){          
                y[i]= (b[i]/a[i][i]);
                 for(int j=0;j<n;j++){
                   if(j==i){
                       continue;
                   } 
                   y[i] = y[i]-((a[i][j]/a[i][i])*x[j]);
                   x[i] = y[i];
                  
                   System.out.println(y[i]+"        ");
                  
                 //  p1.add( new JLabel(""+y[i]));
              }
                  col++;
                   DecimalFormat df = new DecimalFormat();
                   df.setMaximumFractionDigits(Integer.parseInt(dp.getText()));
                   st[row][col]= String.valueOf(df.format(y[i]));
             }
              counter =col;
              row++;
                 col = 0;
              m--;
          }
          
           System.out.println("column "+ counter +"   ,,,,, row "+row);
          
                  JFrame frame = new   JFrame("Tabel for Guess Method");

        frame.setSize(650, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
         
       String[][] string =new String[row][n+1];
   
          
              for(int i=0;i<row;i++){
                 for(int j=0;j<=n;j++){
                    string[i][j] = st[i][j];
                     
              }
             }
               String[] st2 =new String[n+1];
                  
                  for(int j=0;j<=n;j++){
                      if(j==0){
                          st2[j] = "K";
                      }else{
                          st2[j] = "x"+j;
                      }
                  }
      
       // String string[][]={{"jkad","akdhid","wdww"},{"jkad","akdhid","wdww"},{"jkad","akdhid","wdww"}};
        //String st2[]={"jkad","akdhid","wdww"}; 
        JTable table = new JTable(string,st2 );
        table.setLayout(new FlowLayout());
        JScrollPane pane = new JScrollPane(table);
       frame.add(pane,BorderLayout.CENTER);
// display();
         
         
          
              }
               
        
          });
    }
    public static void main(String[] args) {
        
        String sdimention = JOptionPane.showInputDialog("Enter the number of equation");
       n=Integer.parseInt(sdimention);
       
        JFrame frame = new   GuessMethod();

        frame.setSize(750, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
