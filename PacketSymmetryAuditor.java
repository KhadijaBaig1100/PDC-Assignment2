public class PacketSymmetryAuditor {
    public static boolean auditPacket(String payload) {
        if (payload == null || payload.isEmpty()) {
            return false;
        }

        int len = payload.length();
        TransactionStack stack = new TransactionStack(len);
        RequestQueue queue = new RequestQueue(len);

        for (int i = 0; i < len; i++) {
            char c = payload.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }

        return true;
    }
}