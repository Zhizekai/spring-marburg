package com.tjpu.zzk.generator;

import java.util.ArrayList;
import java.util.List;


/**
 * 单表复杂查询所用
 */
public class SpjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;


    public SpjExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQtyIsNull() {
            addCriterion("QTY is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("QTY is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Integer value) {
            addCriterion("QTY =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Integer value) {
            addCriterion("QTY <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Integer value) {
            addCriterion("QTY >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("QTY >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Integer value) {
            addCriterion("QTY <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Integer value) {
            addCriterion("QTY <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Integer> values) {
            addCriterion("QTY in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Integer> values) {
            addCriterion("QTY not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Integer value1, Integer value2) {
            addCriterion("QTY between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("QTY not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andJnoIsNull() {
            addCriterion("JNO is null");
            return (Criteria) this;
        }

        public Criteria andJnoIsNotNull() {
            addCriterion("JNO is not null");
            return (Criteria) this;
        }

        public Criteria andJnoEqualTo(Integer value) {
            addCriterion("JNO =", value, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoNotEqualTo(Integer value) {
            addCriterion("JNO <>", value, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoGreaterThan(Integer value) {
            addCriterion("JNO >", value, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("JNO >=", value, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoLessThan(Integer value) {
            addCriterion("JNO <", value, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoLessThanOrEqualTo(Integer value) {
            addCriterion("JNO <=", value, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoIn(List<Integer> values) {
            addCriterion("JNO in", values, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoNotIn(List<Integer> values) {
            addCriterion("JNO not in", values, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoBetween(Integer value1, Integer value2) {
            addCriterion("JNO between", value1, value2, "jno");
            return (Criteria) this;
        }

        public Criteria andJnoNotBetween(Integer value1, Integer value2) {
            addCriterion("JNO not between", value1, value2, "jno");
            return (Criteria) this;
        }

        public Criteria andPnoIsNull() {
            addCriterion("PNO is null");
            return (Criteria) this;
        }

        public Criteria andPnoIsNotNull() {
            addCriterion("PNO is not null");
            return (Criteria) this;
        }

        public Criteria andPnoEqualTo(Integer value) {
            addCriterion("PNO =", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoNotEqualTo(Integer value) {
            addCriterion("PNO <>", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoGreaterThan(Integer value) {
            addCriterion("PNO >", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("PNO >=", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoLessThan(Integer value) {
            addCriterion("PNO <", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoLessThanOrEqualTo(Integer value) {
            addCriterion("PNO <=", value, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoIn(List<Integer> values) {
            addCriterion("PNO in", values, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoNotIn(List<Integer> values) {
            addCriterion("PNO not in", values, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoBetween(Integer value1, Integer value2) {
            addCriterion("PNO between", value1, value2, "pno");
            return (Criteria) this;
        }

        public Criteria andPnoNotBetween(Integer value1, Integer value2) {
            addCriterion("PNO not between", value1, value2, "pno");
            return (Criteria) this;
        }

        public Criteria andSnoIsNull() {
            addCriterion("SNO is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("SNO is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(Integer value) {
            addCriterion("SNO =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(Integer value) {
            addCriterion("SNO <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(Integer value) {
            addCriterion("SNO >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SNO >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(Integer value) {
            addCriterion("SNO <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(Integer value) {
            addCriterion("SNO <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<Integer> values) {
            addCriterion("SNO in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<Integer> values) {
            addCriterion("SNO not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(Integer value1, Integer value2) {
            addCriterion("SNO between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(Integer value1, Integer value2) {
            addCriterion("SNO not between", value1, value2, "sno");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}