import netscape.security.UserTarget;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null && storage[i] != r) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume search = null;
        for (Resume resume : storage) {
            if (resume != null && resume.getUuid().equals(uuid)) {
                search = resume;
                break;
            }
        }
        return search;
    }

    void delete(String uuid) {
        ArrayList<Resume> resumeArrayList = new ArrayList<>();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = null;
                } else {
                    resumeArrayList.add(storage[i]);
                }
            }
        }
        clear();
        resumeArrayList.toArray(storage);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count = i;
            }
        }
        Resume[] resumeAll = new Resume[count + 1];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                resumeAll[i] = storage[i];
            }
        }
        return resumeAll;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size++;
            }
        }
        return size;
    }
}
