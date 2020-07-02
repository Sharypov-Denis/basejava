import netscape.security.UserTarget;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;


    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null && storage[i] != r) {
                storage[i] = r;
                size++;
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
        Resume[] resumeDelete = new Resume[1000];
        int positionNewArray = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getUuid().equals(uuid)) {
                    size--;
                } else {
                    resumeDelete[positionNewArray] = storage[i];
                    positionNewArray++;
                }
            } else {
                break;
            }
        }
        clear();
        storage = Arrays.stream(resumeDelete).toArray(Resume[]::new);
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
        return size;
    }
}
