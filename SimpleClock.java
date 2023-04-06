//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class SimpleClock extends JFrame {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
        SimpleDateFormat timeMilitaryFormat;
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;
        JButton twelveTwentyfour;
        JButton timeZone;
        boolean militaryOnOff = false;
        boolean gmtOnOff = false;

        SimpleClock() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(380, 240);
            this.setResizable(false);
    
            timeFormat = new SimpleDateFormat("hh:mm:ss a");

            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));

            twelveTwentyfour = new JButton("Military Time");
            twelveTwentyfour.addActionListener(this::changeMilitaryTime);
            timeZone = new JButton("GMT");
            timeZone.addActionListener(this::gmtTime);
    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.add(twelveTwentyfour);
            this.add(timeZone);
            this.setVisible(true);
    
            setTimer();
        }

    private void gmtTime(ActionEvent actionEvent) {
        if (gmtOnOff){
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            gmtOnOff = false;
        } else {
            timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            gmtOnOff = true;
        }
    }

    private void changeMilitaryTime(ActionEvent actionEvent) {
        if (militaryOnOff) {
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            militaryOnOff = false;
        } else  {
            timeFormat = new SimpleDateFormat("HH:mm:ss");
            militaryOnOff = true;
        }
    }



    public void setTimer() {
            while (true) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
    
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            new SimpleClock();
        }
    }
