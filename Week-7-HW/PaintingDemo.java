class ArtPiece {
    String title;
    String artist;

    ArtPiece(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    void displayInfo() {
        System.out.println("Artwork: " + title + " by " + artist);
    }
}

class Painting extends ArtPiece {
    String brushTechnique;
    String colorPalette;
    String frameSpec;

    Painting(String title, String artist, String brushTechnique, String colorPalette, String frameSpec) {
        super(title, artist);
        this.brushTechnique = brushTechnique;
        this.colorPalette = colorPalette;
        this.frameSpec = frameSpec;
    }

    void showPaintingDetails() {
        System.out.println("Painting Details:");
        System.out.println("Brush Technique: " + brushTechnique);
        System.out.println("Color Palette: " + colorPalette);
        System.out.println("Frame Spec: " + frameSpec);
    }
}

class Sculpture extends ArtPiece {
    String material;
    String dimensions;
    String lighting;

    Sculpture(String title, String artist, String material, String dimensions, String lighting) {
        super(title, artist);
        this.material = material;
        this.dimensions = dimensions;
        this.lighting = lighting;
    }

    void showSculptureDetails() {
        System.out.println("Sculpture Details:");
        System.out.println("Material: " + material);
        System.out.println("Dimensions: " + dimensions);
        System.out.println("Lighting: " + lighting);
    }
}

class DigitalArt extends ArtPiece {
    String resolution;
    String fileFormat;
    String interactiveElements;

    DigitalArt(String title, String artist, String resolution, String fileFormat, String interactiveElements) {
        super(title, artist);
        this.resolution = resolution;
        this.fileFormat = fileFormat;
        this.interactiveElements = interactiveElements;
    }

    void showDigitalArtDetails() {
        System.out.println("Digital Art Details:");
        System.out.println("Resolution: " + resolution);
        System.out.println("File Format: " + fileFormat);
        System.out.println("Interactive Elements: " + interactiveElements);
    }
}

class Photography extends ArtPiece {
    String cameraSettings;
    String editingDetails;
    String printSpecs;

    Photography(String title, String artist, String cameraSettings, String editingDetails, String printSpecs) {
        super(title, artist);
        this.cameraSettings = cameraSettings;
        this.editingDetails = editingDetails;
        this.printSpecs = printSpecs;
    }

    void showPhotographyDetails() {
        System.out.println("Photography Details:");
        System.out.println("Camera Settings: " + cameraSettings);
        System.out.println("Editing Details: " + editingDetails);
        System.out.println("Print Specs: " + printSpecs);
    }
}

public class PaintingDemo{
    public static void main(String[] args) {
        ArtPiece[] gallery = new ArtPiece[4];

        gallery[0] = new Painting("Starry Night", "Van Gogh", "Impasto", "Blue/Yellow", "Wooden Frame");
        gallery[1] = new Sculpture("David", "Michelangelo", "Marble", "17ft", "Spotlight");
        gallery[2] = new DigitalArt("Virtual Dreams", "Alice", "4K", "MP4", "VR Support");
        gallery[3] = new Photography("Morning Dew", "Bob", "ISO 100, f/2.8", "Light Retouch", "Glossy A4");

        for (ArtPiece art : gallery) {
            art.displayInfo();

            if (art instanceof Painting) {
                ((Painting) art).showPaintingDetails();
            } else if (art instanceof Sculpture) {
                ((Sculpture) art).showSculptureDetails();
            } else if (art instanceof DigitalArt) {
                ((DigitalArt) art).showDigitalArtDetails();
            } else if (art instanceof Photography) {
                ((Photography) art).showPhotographyDetails();
            }

            System.out.println();
        }
    }
}
