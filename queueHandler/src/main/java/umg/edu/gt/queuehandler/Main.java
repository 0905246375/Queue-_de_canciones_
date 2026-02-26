package umg.edu.gt.queuehandler;

public class Main {

	private static int totalSongsPlayed = 0;
	private static int totalSecondsPlayed = 0;
	
	    public static void main(String[] args) {

	        umg.edu.gt.data_structure.queue.manual.QueueLinked<umg.edu.gt.queuehandler.model.Song> highPriorityQueue =
	                new umg.edu.gt.data_structure.queue.manual.QueueLinked<>();

	        umg.edu.gt.data_structure.queue.manual.QueueLinked<umg.edu.gt.queuehandler.model.Song> normalPriorityQueue =
	                new umg.edu.gt.data_structure.queue.manual.QueueLinked<>();

	        highPriorityQueue.enqueue(
	                new umg.edu.gt.queuehandler.model.Song("Song A", "Artist A", 8, 1)
	        );
	        System.out.println("[LOG] Added HIGH priority: Song A");
	        
	        highPriorityQueue.enqueue(
	                new umg.edu.gt.queuehandler.model.Song("Song B", "Artist B", 12, 1)
	        );
	        System.out.println("[LOG] Added HIGH priority: Song B");

	        normalPriorityQueue.enqueue(
	                new umg.edu.gt.queuehandler.model.Song("Song C", "Artist C", 6, 2)
	        );
	        System.out.println("[LOG] Added NORMAL priority: Song C");
	        
	        normalPriorityQueue.enqueue(
	                new umg.edu.gt.queuehandler.model.Song("Song D", "Artist D", 10, 2)
	        );
	        System.out.println("[LOG] Added NORMAL priority: Song D");
	        
	        System.out.println("[LOG] Starting playlist...");

	        System.out.println("[LOG] Playing HIGH priority queue...");
	        playQueue(highPriorityQueue);
	        
	        System.out.println("[LOG] Playing NORMAL priority queue...");
	        playQueue(normalPriorityQueue);

	        System.out.println("[LOG] Playlist finished.");
	    }

	    private static void playQueue(
	        umg.edu.gt.data_structure.queue.manual.QueueLinked<umg.edu.gt.queuehandler.model.Song> queue
	    ) {
	        while (!queue.isEmpty()) {
	            umg.edu.gt.queuehandler.model.Song song = queue.dequeue();
	            playSong(song);
	        }
	    }

	    private static void playSong(umg.edu.gt.queuehandler.model.Song song) {

	        System.out.println("[LOG] Now playing: "
	                + song.getTitle() + " - "
	                + song.getArtist()
	                + " (" + song.getDuration() + "s)");

	        for (int second = 1; second <= song.getDuration(); second++) {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	            
	            totalSecondsPlayed++; 

	            System.out.println("[LOG] Playing: "
	                    + song.getTitle()
	                    + " | " + second + "s / "
	                    + song.getDuration() + "s");
	        }

	        System.out.println("[LOG] Finished: " + song.getTitle());
	        totalSongsPlayed++;
	        System.out.println("[LOG] Total songs played: " + totalSongsPlayed);
	        System.out.println("[LOG] Total time played: " + totalSecondsPlayed + " seconds");
	    }
}

