# QA Test Generation Lab (Selenium + TestNG)

## Objective
Learn to use GitHub Copilot inside **IntelliJ IDEA** to complete a realistic Danaher/Cepheid engineering task.

## Duration
40-45 minutes

## Prerequisites
- IntelliJ IDEA (Community or Ultimate)
- JDK 17+
- Maven 3.9+
- GitHub Copilot and GitHub Copilot Chat plugins enabled in IntelliJ
- Git

## IntelliJ Setup
1. Open IntelliJ IDEA and choose **File > Open**, then select this repository folder.
2. Trust the project when prompted and let IntelliJ auto-import the Maven project.
3. Confirm the Project SDK is Java 17 in **File > Project Structure > Project**.
4. Open the **Maven** tool window (right sidebar) to run 	est/erify goals.
5. Open **GitHub Copilot Chat** from the right tool bar, keep the relevant file active so Copilot has context.

## Scenario
The CepheidDx diagnostic portal (login, dashboard, product catalog, product details, order creation) has almost no automated coverage beyond a single happy-path login test.

## Starting Point
`LoginPageTest` only checks that the login button is visible after entering credentials. There is no coverage for the dashboard, product search, product details, or order creation flows.

## Hands-on Tasks
1. Open `app/*.html` in IntelliJ and identify the key elements (ids/classes) available for automation on each page.
2. Ask Copilot to list missing test scenarios across the login, dashboard, product search, and order creation flows.
3. Generate a new TestNG test class for navigating from dashboard to the product catalog and opening a product's details page.
4. Generate a new TestNG test class for submitting the order form and asserting the confirmation message appears.
5. Improve locators to use stable `id`/`data-*` attributes instead of fragile text-based selectors.
6. Register new test classes in `src/test/resources/testng.xml` and run the full suite.

## Validation
Run from the IntelliJ **Terminal** tab (Alt+F12) or the Maven tool window:

```bash
mvn test
```

## Expected Result
At least two new TestNG test classes exist (product navigation, order submission) with meaningful assertions, and the suite runs successfully end to end.

## Troubleshooting
- If ChromeDriver fails to start, ensure Google Chrome is installed; Selenium Manager (bundled with Selenium 4.22+) will download the matching driver automatically.
- If a page opens blank, confirm you are using `TestConfig.pageUrl(...)` rather than a hardcoded file path.

## Optional Challenge
Add a data-driven test that searches for each product ID in `products.html` and verifies the corresponding details page shows the correct product ID.

## Copilot Customization Guide

**Already provided:** `.github/instructions/copilot-instructions.md` (QA-specific: Page Object Model, explicit waits, no hardcoded data).

**New prompt file:** `.github/prompts/test-generation-prompt.md`

```
Role: TestNG author for the CepheidDx portal (app/*.html)
Task: List missing scenarios, then generate 1 test class for product navigation
Constraints: stable id/data-* locators only; explicit waits, no sleep
Output: test class + testng.xml entry
```

**Optional stretch tasks (build these yourself â€” not provided):**
- Custom agent: create `.github/agents/qa-test-generator-agent.agent.md` defining a persona that inspects the portal HTML and proposes/generates missing TestNG coverage.
- Skill: create `.github/skills/selenium-test-generation-checklist/SKILL.md` capturing a reusable checklist for turning a UI flow into a stable, assertion-rich test.
- `AGENTS.md`: optionally add a root-level file summarizing repo conventions for cross-tool agent compatibility (Copilot CLI and other agentic tools read this file).

**Enterprise tip:** Enterprise Copilot usage favors small, structured, reusable prompts over long free-form ones. State `Role / Task / Constraints / Output` in under ~5 lines â€” this keeps token usage low and responses focused, which matters when Copilot is used constantly across a team.
