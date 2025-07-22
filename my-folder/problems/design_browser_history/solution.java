class ListNode{
    String page;
    ListNode next;
    ListNode prev;

    public ListNode(String browserPage){
        page = browserPage;
    }
}
class BrowserHistory {

    ListNode browserHist;
    ListNode ptr;
    public BrowserHistory(String homepage) {
        browserHist = new ListNode(homepage);
        ptr = browserHist;
    }
    
    public void visit(String url) {
        ListNode webPage = new ListNode(url);
        ptr.next = webPage;
        webPage.prev = ptr;
        ptr = ptr.next;
    }
    
    public String back(int steps) {
        while(steps > 0 && ptr != browserHist){
            ptr = ptr.prev;
            steps--;
        }
        return ptr.page;
    }
    
    public String forward(int steps) {
        while(steps > 0 && ptr.next != null){
            ptr = ptr.next;
            steps--;
        }
        return ptr.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */