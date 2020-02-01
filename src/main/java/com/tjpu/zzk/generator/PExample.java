package com.tjpu.zzk.generator;

import java.util.ArrayList;
import java.util.List;

public class PExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PExample() {
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

        public Criteria andPNOIsNull() {
            addCriterion("PNO is null");
            return (Criteria) this;
        }

        public Criteria andPNOIsNotNull() {
            addCriterion("PNO is not null");
            return (Criteria) this;
        }

        public Criteria andPNOEqualTo(Integer value) {
            addCriterion("PNO =", value, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNONotEqualTo(Integer value) {
            addCriterion("PNO <>", value, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNOGreaterThan(Integer value) {
            addCriterion("PNO >", value, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNOGreaterThanOrEqualTo(Integer value) {
            addCriterion("PNO >=", value, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNOLessThan(Integer value) {
            addCriterion("PNO <", value, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNOLessThanOrEqualTo(Integer value) {
            addCriterion("PNO <=", value, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNOIn(List<Integer> values) {
            addCriterion("PNO in", values, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNONotIn(List<Integer> values) {
            addCriterion("PNO not in", values, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNOBetween(Integer value1, Integer value2) {
            addCriterion("PNO between", value1, value2, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNONotBetween(Integer value1, Integer value2) {
            addCriterion("PNO not between", value1, value2, "PNO");
            return (Criteria) this;
        }

        public Criteria andPNAMEIsNull() {
            addCriterion("PNAME is null");
            return (Criteria) this;
        }

        public Criteria andPNAMEIsNotNull() {
            addCriterion("PNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPNAMEEqualTo(String value) {
            addCriterion("PNAME =", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotEqualTo(String value) {
            addCriterion("PNAME <>", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEGreaterThan(String value) {
            addCriterion("PNAME >", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("PNAME >=", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMELessThan(String value) {
            addCriterion("PNAME <", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMELessThanOrEqualTo(String value) {
            addCriterion("PNAME <=", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMELike(String value) {
            addCriterion("PNAME like", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotLike(String value) {
            addCriterion("PNAME not like", value, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEIn(List<String> values) {
            addCriterion("PNAME in", values, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotIn(List<String> values) {
            addCriterion("PNAME not in", values, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMEBetween(String value1, String value2) {
            addCriterion("PNAME between", value1, value2, "PNAME");
            return (Criteria) this;
        }

        public Criteria andPNAMENotBetween(String value1, String value2) {
            addCriterion("PNAME not between", value1, value2, "PNAME");
            return (Criteria) this;
        }

        public Criteria andCOLORIsNull() {
            addCriterion("COLOR is null");
            return (Criteria) this;
        }

        public Criteria andCOLORIsNotNull() {
            addCriterion("COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andCOLOREqualTo(String value) {
            addCriterion("COLOR =", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORNotEqualTo(String value) {
            addCriterion("COLOR <>", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORGreaterThan(String value) {
            addCriterion("COLOR >", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORGreaterThanOrEqualTo(String value) {
            addCriterion("COLOR >=", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORLessThan(String value) {
            addCriterion("COLOR <", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORLessThanOrEqualTo(String value) {
            addCriterion("COLOR <=", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORLike(String value) {
            addCriterion("COLOR like", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORNotLike(String value) {
            addCriterion("COLOR not like", value, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORIn(List<String> values) {
            addCriterion("COLOR in", values, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORNotIn(List<String> values) {
            addCriterion("COLOR not in", values, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORBetween(String value1, String value2) {
            addCriterion("COLOR between", value1, value2, "COLOR");
            return (Criteria) this;
        }

        public Criteria andCOLORNotBetween(String value1, String value2) {
            addCriterion("COLOR not between", value1, value2, "COLOR");
            return (Criteria) this;
        }

        public Criteria andWEIGHTIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWEIGHTIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWEIGHTEqualTo(String value) {
            addCriterion("WEIGHT =", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTNotEqualTo(String value) {
            addCriterion("WEIGHT <>", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTGreaterThan(String value) {
            addCriterion("WEIGHT >", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTGreaterThanOrEqualTo(String value) {
            addCriterion("WEIGHT >=", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTLessThan(String value) {
            addCriterion("WEIGHT <", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTLessThanOrEqualTo(String value) {
            addCriterion("WEIGHT <=", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTLike(String value) {
            addCriterion("WEIGHT like", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTNotLike(String value) {
            addCriterion("WEIGHT not like", value, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTIn(List<String> values) {
            addCriterion("WEIGHT in", values, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTNotIn(List<String> values) {
            addCriterion("WEIGHT not in", values, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTBetween(String value1, String value2) {
            addCriterion("WEIGHT between", value1, value2, "WEIGHT");
            return (Criteria) this;
        }

        public Criteria andWEIGHTNotBetween(String value1, String value2) {
            addCriterion("WEIGHT not between", value1, value2, "WEIGHT");
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