import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.util.EventListener;

/**
 * Created by Dmitrii on 01.04.2017.
 */
public interface ActionHandler extends EventListener  {
    void actionPerformed(ActionEvent e) throws UnsupportedEncodingException;
}
