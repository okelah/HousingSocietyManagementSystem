package Others;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import javax.swing.*;

/**
 * The <code>ViewerComponentExample</code> class is an example of how to use
 * <code>SwingController</code> and <code>SwingViewBuilder</code>
 * to build a PDF viewer component.  A file specified at the command line is
 * opened in a JFrame which contains the viewer component.
 *
 * @since 2.0
 */
public class PdfViewer {
    public static void view(String path) {
        // Get a file from the command line to open
        String filePath = path;

        // build a component controller
        SwingController controller = new SwingController();

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        JFrame applicationFrame = new JFrame();
        applicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applicationFrame.getContentPane().add(viewerComponentPanel);

        // Now that the GUI is all in place, we can try openning a PDF
        controller.openDocument(filePath);

        // show the component
        applicationFrame.pack();
        applicationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        applicationFrame.setVisible(true);
    }
}