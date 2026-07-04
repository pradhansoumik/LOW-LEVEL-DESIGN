# LOW-LEVEL-DESIGN
### Repo contains code example of below -

    > software design principles
    > solid principles
    > all design patterns
        > creational
        > structural
        > behavioral
    > Design Case Study etc.


## Understanding

Let us understand this with a simple real-life example. Think of building a house:

- **High-Level Design (HLD) is like the architect's blueprint** — it says where the rooms will be, how big they are, and how they're connected.
- **Low-Level Design (LLD) is like deciding** - where the switches go, how the plumbing is laid out, what materials to use, etc.

So LLD is all about the small, detailed planning you do before actually building the house (or writing code).

## Hierarchy at a glance

How **Software Design Principles**, **HLD/LLD**, **SOLID**, and **Design Patterns** relate (superset / subset view):

```
┌─────────────────────────────────────────────────────────────┐
│  SOFTWARE DESIGN PRINCIPLES  (broadest — "why/how")         │
│  DRY · KISS · YAGNI · Separation of Concerns · ...          │
│                                                             │
│    ┌─────────────────────────────────────────────────────┐  │
│    │  SOLID PRINCIPLES  (subset — OOP-focused)           │  │
│    │  SRP · OCP · LSP · ISP · DIP                        │  │
│    └─────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
              │ applies to both levels ↓
    ┌─────────────────┐         ┌─────────────────┐
    │      HLD        │  ───►   │      LLD        │
    │  (what & where) │         │  (how & detail) │
    └─────────────────┘         └─────────────────┘
              │                           │
    Architectural patterns        Design patterns (GoF)
    (MVC, Layered, etc.)          (Factory, Observer, etc.)
```

| Concept | Role | Superset / subset |
|---------|------|-------------------|
| **Software Design Principles** | Broad guidelines for understandable, maintainable, extensible systems | **Superset** of SOLID (and DRY, KISS, YAGNI, etc.) |
| **HLD** | Blueprint: components, boundaries, how they connect | A **design stage** — not a superset of principles |
| **LLD** | Detail: classes, APIs, data structures, interactions inside a component | A **design stage** — where SOLID and most patterns land |
| **SOLID** | Five OOP rules for clean, scalable code | **Subset** of software design principles |
| **Design Patterns** | Named, reusable solutions to recurring problems | **Not a subset of principles** — they **implement** principles; mostly used in **LLD** (some in **HLD**) |

**Key relationships**

1. **Software Design Principles ⊃ SOLID** — SOLID is one focused family inside the larger principles family.
2. **Principles → HLD & LLD** — DRY/KISS apply everywhere; SOLID is strongest at LLD (classes, interfaces, objects).
3. **HLD → LLD** — HLD is the map; LLD is the detailed plan for each part on the map.
4. **Design Patterns ≈ "how" that follows "why"** — Patterns are templates, not principles (e.g. Strategy supports Open/Closed; Factory supports Dependency Inversion).
5. **Patterns mostly live in LLD** — Creational / Structural / Behavioral patterns are LLD tools; MVC, Layered Architecture, and Microservices are architectural patterns at HLD.

> **Principles** tell you *what to optimize for* → **HLD/LLD** tell you *at what level you design* → **SOLID** is a *specialized subset of principles for OOP* → **Design patterns** are *proven building blocks that put those principles into practice*, mainly at LLD.