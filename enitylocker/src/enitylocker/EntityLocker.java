package enitylocker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public final class EntityLocker {

    public static final EntityLocker INSTANCE = new EntityLocker();

    private ConcurrentHashMap<Object, ReentrantLock> locks = new ConcurrentHashMap<>();
    private ReentrantLock globalLock = new ReentrantLock();

    private EntityLocker() {
    }

    public void lock(Object id) {
        checkParam(id);
        ReentrantLock lock = locks.computeIfAbsent(id, key -> new ReentrantLock());//atomic
        lock.lock();
    }

    public void unlock(Object id) {
        checkParam(id);
        ReentrantLock lock = locks.get(id);//atomic
        boolean removed = locks.remove(id, lock);//atomic
        if (removed) {
            lock.unlock();
        }
    }

    public boolean lockGlobally() {
        boolean locked = globalLock.tryLock();
        if (locked) {
            if (locks.isEmpty()) {
                return true;
            } else {
                globalLock.unlock();
                return false;
            }
        }
        return locked;
    }

    public void unlockGlobally() {
        globalLock.unlock();
    }

    private void checkParam(Object id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

}
