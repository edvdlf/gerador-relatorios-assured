package br.com.vetorit.fasttax.integracao.model;

import java.util.List;

public class PaginatedResponse<T> {
    private List<T> content;
    private Pageable pageable;
    private boolean last;
    private int totalPages;
    private int totalElements;
    private int size;
    private int number;
    private Sort sort;
    private boolean first;
    private int numberOfElements;
    private boolean empty;
    
    

    // Getters e Setters

    public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public static class Pageable {
        private int pageNumber;
        private int pageSize;
        private Sort sort;
        private int offset;
        private boolean paged;
        private boolean unpaged;
		public int getPageNumber() {
			return pageNumber;
		}
		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public Sort getSort() {
			return sort;
		}
		public void setSort(Sort sort) {
			this.sort = sort;
		}
		public int getOffset() {
			return offset;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}
		public boolean isPaged() {
			return paged;
		}
		public void setPaged(boolean paged) {
			this.paged = paged;
		}
		public boolean isUnpaged() {
			return unpaged;
		}
		public void setUnpaged(boolean unpaged) {
			this.unpaged = unpaged;
		}
        
        

        // Getters e Setters
    }

    public static class Sort {
        private boolean empty;
        private boolean sorted;
        private boolean unsorted;
		public boolean isEmpty() {
			return empty;
		}
		public void setEmpty(boolean empty) {
			this.empty = empty;
		}
		public boolean isSorted() {
			return sorted;
		}
		public void setSorted(boolean sorted) {
			this.sorted = sorted;
		}
		public boolean isUnsorted() {
			return unsorted;
		}
		public void setUnsorted(boolean unsorted) {
			this.unsorted = unsorted;
		}
        
        
        // Getters e Setters
        
        
    }
}
